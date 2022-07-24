package uz.darkor.darkor_22.config.security.filters;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import uz.darkor.darkor_22.dto.auth.auth_user.AuthUserLoginDTO;
import uz.darkor.darkor_22.dto.auth.token.AuthTokenCreateDTO;
import uz.darkor.darkor_22.dto.auth.token.AuthTokenGetDTO;
import uz.darkor.darkor_22.dto.auth.token.TokenResponseDTO;
import uz.darkor.darkor_22.entity.auth.session.SessionUser;
import uz.darkor.darkor_22.enums.AuthTokenTypeEnum;
import uz.darkor.darkor_22.response.APIErrorDTO;
import uz.darkor.darkor_22.response.Data;
import uz.darkor.darkor_22.service.token.AuthTokenService;
import uz.darkor.darkor_22.utils.jwt.JWTUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthTokenService authTokenService;
    private final AuthenticationManager authenticationManager;

    public CustomAuthenticationFilter(AuthTokenService authTokenService, AuthenticationManager authenticationManager) {
        this.authTokenService = authTokenService;
        this.authenticationManager = authenticationManager;
        super.setFilterProcessesUrl("/api/v1/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            AuthUserLoginDTO dto = new ObjectMapper().readValue(request.getReader(), AuthUserLoginDTO.class);
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword());
            return authenticationManager.authenticate(token);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentic) throws IOException, ServletException {
        SessionUser user = (SessionUser) authentic.getPrincipal();
        Date accessDate = JWTUtils.getExpiry();
        Date refreshDate = JWTUtils.getExpiryForRefreshToken();

        String accessToken = JWT.create().withSubject(user.getEmail()).withExpiresAt(accessDate).withIssuer(request.getRequestURL().toString()).withClaim("role", user.getRole().name()).sign(JWTUtils.getAlgorithm());
        String refreshToken = JWT.create().withSubject(user.getEmail()).withExpiresAt(refreshDate).withIssuer(request.getRequestURL().toString()).withClaim("role", user.getRole().name()).sign(JWTUtils.getAlgorithm());

        AuthTokenCreateDTO tokenCreateDTO1 = new AuthTokenCreateDTO(user.getCode(), accessToken, accessDate, AuthTokenTypeEnum.ACCESS_TOKEN.name());
        AuthTokenCreateDTO tokenCreateDTO2 = new AuthTokenCreateDTO(user.getCode(), refreshToken, refreshDate, AuthTokenTypeEnum.REFRESH_TOKEN.name());

        authTokenService.create(tokenCreateDTO1);
        authTokenService.create(tokenCreateDTO2);

        AuthTokenGetDTO tokenGetDTO1 = new AuthTokenGetDTO(AuthTokenTypeEnum.ACCESS_TOKEN.name(), accessToken);
        AuthTokenGetDTO tokenGetDTO2 = new AuthTokenGetDTO(AuthTokenTypeEnum.REFRESH_TOKEN.name(), refreshToken);
        TokenResponseDTO responseDTO = new TokenResponseDTO(tokenGetDTO1, tokenGetDTO2, user.getRole().name());

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(), responseDTO);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        Data<APIErrorDTO> errorData = new Data<>(new APIErrorDTO(failed.getMessage(), failed.getMessage(), request.getRequestURL().toString(), HttpStatus.INTERNAL_SERVER_ERROR.value(), Timestamp.valueOf(LocalDateTime.now())));
        errorData.setSuccess(false);
        new ObjectMapper().writeValue(response.getOutputStream(), errorData);
    }
}
