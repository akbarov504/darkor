package uz.darkor.darkor_22.entity.auth.session;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uz.darkor.darkor_22.entity.auth.AuthUser;
import uz.darkor.darkor_22.enums.AuthRole;

import java.util.*;

@Getter
@Setter
@ToString
public class SessionUser implements UserDetails {
    private UUID code;
    private String fullName;
    private String password;
    private String email;
    private String verifyCode;
    private String phone;
    private AuthRole role;

    public SessionUser(AuthUser user) {
        code = user.getCode();
        fullName = user.getFullName();
        password = user.getPassword();
        email = user.getEmail();
        phone = user.getPhoneNumber();
        verifyCode = user.getVerificationCode();
        role = user.getRole();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        if (Objects.isNull(this.role)) {
            return authorities;
        }
        authorities.add(new SimpleGrantedAuthority(role.name()));
        return authorities;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
