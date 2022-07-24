package uz.darkor.darkor_22.dto.auth.token;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TokenResponseDTO {
    private AuthTokenGetDTO accessToken;
    private AuthTokenGetDTO refreshToken;
    private String role;
}
