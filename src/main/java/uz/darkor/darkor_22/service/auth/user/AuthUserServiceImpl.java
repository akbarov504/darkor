package uz.darkor.darkor_22.service.auth.user;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import uz.darkor.darkor_22.config.encrytion.PasswordEncoderConfigurer;
import uz.darkor.darkor_22.config.security.jwt.JWTUtils;
import uz.darkor.darkor_22.criteria.BaseCriteria;
import uz.darkor.darkor_22.dto.auth.PasswordDto;
import uz.darkor.darkor_22.dto.auth.auth_user.*;
import uz.darkor.darkor_22.entity.auth.security_utils.AuthUser;
import uz.darkor.darkor_22.entity.auth.security_utils.CustomUserDetails;
import uz.darkor.darkor_22.exception.NotFoundException;
import uz.darkor.darkor_22.mapper.auth.AuthUserMapper;
import uz.darkor.darkor_22.repository.auth.AuthUserRepository;
import uz.darkor.darkor_22.response.APIErrorDTO;
import uz.darkor.darkor_22.response.Data;
import uz.darkor.darkor_22.service.AbstractService;
import uz.darkor.darkor_22.utils.BaseUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthUserServiceImpl extends AbstractService<AuthUserMapper, AuthUserRepository> implements AuthUserService {

    private final PasswordEncoderConfigurer passwordEncoder;

    private final ObjectMapper objectMapper;


    public AuthUserServiceImpl(AuthUserMapper mapper,
                               AuthUserRepository repository,
                               PasswordEncoderConfigurer passwordEncoder,
                               ObjectMapper objectMapper) {
        super(mapper, repository);
        this.passwordEncoder = passwordEncoder;
        this.objectMapper = objectMapper;
    }

    @Override
    public AuthUserGetDTO create(AuthUserCreateDTO DTO) {
        AuthUser authUser = mapper.fromCreateDTO(DTO);
        String encode = passwordEncoder.passwordEncoder().encode(DTO.getPassword());
        authUser.setPassword(encode);
        AuthUser save = repository.save(authUser);
        return mapper.toGetDTO(save);
    }

    @Override
    public AuthUserGetDTO update(AuthUserUpdateDTO DTO) {
        AuthUser target = checkExistenceAndGetById(DTO.getId());
        AuthUser authUser = mapper.fromUpdateDTO(DTO, target);
        AuthUser save = repository.save(authUser);
        return mapper.toGetDTO(save);
    }

    @Override
    public Boolean delete(Long key) {
        AuthUser authUser = checkExistenceAndGetById(key);
        repository.delete(authUser);
        return Boolean.TRUE;
    }

    @Override
    public AuthUserGetDTO get(Long key, String language) {
        AuthUser authUser = checkExistenceAndGetById(key);
        return mapper.toGetDTO(authUser);
    }

    @Override
    public List<AuthUserGetDTO> list(BaseCriteria criteria, String language) {
        List<AuthUser> all = repository.findAll();
        return mapper.toListDTO(all);
    }

    private AuthUser checkExistenceAndGetById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("AUTH_USER_NOT_FOUND"));
    }

    public void resetPassword(PasswordDto dto) {
        Optional<AuthUser> user = repository.findById(dto.getId());
        if (user.isEmpty()) {
            throw new NotFoundException("User not found");
        }
        if (!dto.getOldPass().equalsIgnoreCase(dto.getNewPassword())) {
            throw new RuntimeException("Password doesn't match.");
        }
        repository.resetPassword(passwordEncoder.passwordEncoder().encode(dto.getNewPassword()), dto.getId());
    }


    public ResponseEntity<Data<SessionDto>> getToken(LoginDto dto) {
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpPost httppost = new HttpPost("http://localhost:8080"+BaseUtils.PATH + "/login");
            byte[] bytes = objectMapper.writeValueAsBytes(dto);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            httppost.addHeader("Content-Type", "application/x-www-form-urlencoded");
            httppost.setEntity(new InputStreamEntity(byteArrayInputStream));

            HttpResponse response = client.execute(httppost);

            HttpEntity entity = response.getEntity();
            JsonNode json_auth = objectMapper.readTree(EntityUtils.toString(entity));

            if (json_auth.has("success") && json_auth.get("success").asBoolean()) {
                JsonNode node = json_auth.get("data");
                SessionDto sessionDto = objectMapper.readValue(node.toString(), SessionDto.class);
                return new ResponseEntity<>(new Data<>(sessionDto),
                        HttpStatus.OK);
            }
            return new ResponseEntity<>(
                    new Data<>(objectMapper.readValue(json_auth.get("error").toString(), APIErrorDTO.class)),
                    HttpStatus.OK);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(
                    new Data<>(APIErrorDTO.builder()
                            .message(e.getLocalizedMessage())
                            .date(Timestamp.valueOf(LocalDateTime.now()))
                            .build()),
                    HttpStatus.OK);
        }
    }

//    public SessionDto refreshToken(
//            String refreshToken,
//            HttpServletRequest request,
//            HttpServletResponse response) {
//        Date expiry = JWTUtils.getExpiry();
//        CustomUserDetails user = (CustomUserDetails) verifyToken(refreshToken);
//        String accessToken = JWT.create()
//                .withSubject(user.getUsername())
//                .withExpiresAt(expiry)
//                .withIssuer(request.getRequestURL().toString())
//                .withClaim("roles",
//                        user.
//                                getAuthorities().
//                                stream().
//                                map(GrantedAuthority::getAuthority).
//                                collect(Collectors.toList()))
//                .withClaim("id", user.getId())
//                .withClaim("active", user.isEnabled())
//                .withClaim("blocked", user.isBlocked())
//                .sign(JWTUtils.getAlgorithm());
//
//        SessionDto sessionDto = SessionDto.builder()
//                .accessToken(accessToken)
//                .accessTokenExpiry(expiry.getTime())
//                .refreshToken(refreshToken)
//                .refreshTokenExpiry(JWTUtils.getExpiryForRefreshToken().getTime())
//                .issuedAt(System.currentTimeMillis())
//                .build();
//
//        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        try {
//            new ObjectMapper().writeValue(response.getOutputStream(), new Data<>(sessionDto));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return sessionDto;
//    }

//    public ResponseEntity<Data<Void>> addUser(Long id) {
//        AuthUser user = repository.findByIdAndDeletedFalse(id);
//        user.setVerificationCode(RandomString.make(64));
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("warehouse@gmail.com");
//        message.setTo(user.getEmail());
//        message.setSubject("Assalomu alaykum ");
//        message.setText("http://localhost:8080/api/auth/accept/" + user.getVerificationCode());
//        mailSender.send(message);
//        repository.save(user);
//        return new ResponseEntity<>(new Data<>(null));
//    }

//    public ResponseEntity<Data<Boolean>> accept(String code) {
//
//        validator.validateCode(code);
//        Optional<AuthUser> user = repository.findByVerificationCodeAndDeletedFalse(code);
//        validator.validateUser(user);
//        user.get().setActive(true);
//        repository.save(user.get());
//        return new ResponseEntity<>(new Data<>(true));
//    }
//
//
//    private UserDetails verifyToken(String token) {
//        DecodedJWT decodedJWT = JWTUtils.getVerifier().verify(token);
//        String email = decodedJWT.getSubject();
//        return loadUserByUsername(email);
//    }
}
