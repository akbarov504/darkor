package uz.darkor.darkor_22.service.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import uz.darkor.darkor_22.criteria.token.AuthTokenCriteria;
import uz.darkor.darkor_22.dto.auth.token.AuthTokenCreateDTO;
import uz.darkor.darkor_22.dto.auth.token.AuthTokenGetDTO;
import uz.darkor.darkor_22.dto.auth.token.AuthTokenUpdateDTO;
import uz.darkor.darkor_22.dto.auth.token.TokenResponseDTO;
import uz.darkor.darkor_22.entity.auth.AuthUser;
import uz.darkor.darkor_22.enums.AuthTokenTypeEnum;
import uz.darkor.darkor_22.mapper.token.AuthTokenMapper;
import uz.darkor.darkor_22.repository.token.AuthTokenRepository;
import uz.darkor.darkor_22.repository.user.AuthUserRepository;
import uz.darkor.darkor_22.service.AbstractService;
import uz.darkor.darkor_22.utils.jwt.JWTUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.*;

@Service
@Transactional
public class AuthTokenServiceImpl extends AbstractService<AuthTokenMapper, AuthTokenRepository> implements AuthTokenService {
    private final AuthUserRepository authUserRepository;

    public AuthTokenServiceImpl(AuthTokenMapper mapper, AuthTokenRepository repository, AuthUserRepository authUserRepository) {
        super(mapper, repository);
        this.authUserRepository = authUserRepository;
    }

    @Override
    public AuthTokenGetDTO create(AuthTokenCreateDTO DTO) {
        return mapper.toGetDTO(repository.save(mapper.toCreateDTO(DTO)));
    }

    @Override
    public AuthTokenGetDTO update(AuthTokenUpdateDTO DTO) {
        return null;
    }

    @Override
    public Boolean delete(UUID key) {
        return null;
    }

    @Override
    public AuthTokenGetDTO get(UUID key, String language) {
        return null;
    }

    @Override
    public List<AuthTokenGetDTO> list(AuthTokenCriteria criteria, String language) {
        return null;
    }

    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                String refreshToken = authorizationHeader.substring("Bearer ".length());
                DecodedJWT jwt = JWTUtils.getVerifier().verify(refreshToken);
                String email = jwt.getSubject();
                AuthUser user = authUserRepository.findByEmail(email);
                Date accessDate = JWTUtils.getExpiry();

                String accessToken = JWT.create().withSubject(user.getEmail()).withExpiresAt(accessDate).withIssuer(request.getRequestURL().toString()).withClaim("role", user.getRole().name()).sign(JWTUtils.getAlgorithm());

                AuthTokenCreateDTO tokenCreateDTO = new AuthTokenCreateDTO(user.getCode(), accessToken, accessDate, AuthTokenTypeEnum.ACCESS_TOKEN.name());
                create(tokenCreateDTO);

                AuthTokenGetDTO tokenGetDTO1 = new AuthTokenGetDTO(AuthTokenTypeEnum.ACCESS_TOKEN.name(), accessToken);
                AuthTokenGetDTO tokenGetDTO2 = new AuthTokenGetDTO(AuthTokenTypeEnum.REFRESH_TOKEN.name(), refreshToken);
                TokenResponseDTO responseDTO = new TokenResponseDTO(tokenGetDTO1, tokenGetDTO2, user.getRole().name());

                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), responseDTO);
            } catch (Exception e) {
                response.setHeader("error", e.getMessage());
                response.setStatus(HttpStatus.FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("error_message", e.getMessage());
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        } else {
            throw new RuntimeException("Refresh token is missing");
        }
    }
}
