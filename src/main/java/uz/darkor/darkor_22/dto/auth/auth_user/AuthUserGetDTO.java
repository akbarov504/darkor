package uz.darkor.darkor_22.dto.auth.auth_user;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.enums.AuthRole;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserGetDTO extends GenericDTO {

    private Long id;
    private String fullName;

    private String email;

    private String phoneNumber;

    private AuthRole role;

    @Builder
    public AuthUserGetDTO(UUID code, Long id, String fullName, String email, String phoneNumber, AuthRole role) {
        super(code);
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }
}
