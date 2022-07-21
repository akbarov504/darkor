package uz.darkor.darkor_22.dto.auth.auth_user;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SessionDto {
    private Long accessTokenExpiry;
    private Long refreshTokenExpiry;
    private Long issuedAt;
    private String accessToken;
    private String refreshToken;
}
