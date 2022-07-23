package uz.darkor.darkor_22.dto.auth.auth_user;

import lombok.*;
import uz.darkor.darkor_22.dto.BaseDTO;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserLoginDTO implements BaseDTO {
    @NotBlank(message = "email cannot be null")
    private String email;
    @NotBlank(message = "password cannot be null")
    private String password;
}
