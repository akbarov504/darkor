package uz.darkor.darkor_22.entity.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.darkor.darkor_22.entity.Auditable;
import uz.darkor.darkor_22.enums.AuthRole;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class AuthUser extends Auditable {
    private String fullName;
    private String password;
    private String email;
    private String verificationCode;
    private String phoneNumber;
    private AuthRole role;
}
