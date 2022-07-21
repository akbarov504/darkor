package uz.darkor.darkor_22.dto.auth.auth_user;

import lombok.*;
import uz.darkor.darkor_22.dto.BaseDTO;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserCreateDTO implements BaseDTO {

    private String email;

    private String password;

    private String fullName;

    private String phoneNumber;

}
