package uz.darkor.darkor_22.entity.auth.security_utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.darkor.darkor_22.entity.Auditable;
import uz.darkor.darkor_22.enums.AuthRole;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class AuthUser extends Auditable {

    private String fullName;

    private String password;

    private String email;

    private String verificationCode;

    private String phoneNumber;

    @Column(columnDefinition = ("boolean default false"))
    private boolean blocked;

    @Column(columnDefinition = ("boolean default false"))
    private boolean active;

    @Enumerated(EnumType.STRING)
    private AuthRole role;
}
