package uz.darkor.darkor_22.dto.auth.auth_user;

import lombok.*;
import uz.darkor.darkor_22.dto.BaseDTO;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserCreateDTO implements BaseDTO {
    private String fullName;
    private String password;
    private String email;
    private String verificationCode;
    private String phoneNumber;
}
