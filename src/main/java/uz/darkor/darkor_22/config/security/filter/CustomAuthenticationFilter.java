package uz.darkor.darkor_22.config.security.filter;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import uz.darkor.darkor_22.config.security.jwt.JWTUtils;
import uz.darkor.darkor_22.entity.auth.security_utils.CustomUserDetails;
import uz.darkor.darkor_22.dto.auth.auth_user.LoginDto;
import uz.darkor.darkor_22.dto.auth.auth_user.SessionDto;
import uz.darkor.darkor_22.response.APIErrorDTO;
import uz.darkor.darkor_22.response.Data;
import uz.darkor.darkor_22.utils.BaseUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.stream.Collectors;

@Slf4j
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public CustomAuthenticationFilter(AuthenticationManager manager) {
        this.authenticationManager = manager;
        super.setFilterProcessesUrl(BaseUtils.PATH+"/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            LoginDto loginDto = new ObjectMapper().readValue(request.getReader(), LoginDto.class);
            log.info("Email is: {}", loginDto.getEmail());
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword());
            return authenticationManager.authenticate(authenticationToken);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new BadCredentialsException(e.getMessage(), e.getCause());
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authentication) throws IOException {
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        Date expiryForAccessToken = JWTUtils.getExpiry();
        Date expiryForRefreshToken = JWTUtils.getExpiryForRefreshToken();

        String accessToken = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(expiryForAccessToken)
                .withIssuer(request.getRequestURL().toString())
                .withClaim("roles",
                        user.
                                getAuthorities().
                                stream().
                                map(GrantedAuthority::getAuthority).
                                collect(Collectors.toList()))
                .withClaim("id", user.getId())
                .withClaim("active", user.isEnabled())
                .withClaim("blocked", user.isBlocked())
                .sign(JWTUtils.getAlgorithm());

        String refreshToken = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(expiryForRefreshToken)
                .withIssuer(request.getRequestURL().toString())
                .sign(JWTUtils.getAlgorithm());

        SessionDto sessionDto = SessionDto.builder()
                .accessToken(accessToken)
                .accessTokenExpiry(expiryForAccessToken.getTime())
                .refreshToken(refreshToken)
                .refreshTokenExpiry(expiryForRefreshToken.getTime())
                .issuedAt(System.currentTimeMillis())
                .build();

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(), new Data<>(sessionDto));
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request,
                                              HttpServletResponse response,
                                              AuthenticationException failed) throws IOException, ServletException {
        Data<APIErrorDTO> resp = new Data<>(
                APIErrorDTO.builder()
                        .message(failed.getMessage())
                        .path(request.getRequestURL().toString())
                        .build()
        );
        new ObjectMapper().writeValue(response.getOutputStream(), resp);
    }

}
