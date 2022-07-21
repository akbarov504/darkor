package uz.darkor.darkor_22.dto.auth.auth_user;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginDto {

    private String email;
    private String password;
}
