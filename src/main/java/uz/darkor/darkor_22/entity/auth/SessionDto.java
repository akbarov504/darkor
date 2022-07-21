package uz.darkor.darkor_22.entity.auth;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SessionDto {
    private Long accessTokenExpiry;
    private Long refreshTokenExpiry;
    private Long issuedAt;
    private String accessToken;
    private String refreshToken;
}
