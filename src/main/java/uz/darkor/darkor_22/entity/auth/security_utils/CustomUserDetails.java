package uz.darkor.darkor_22.entity.auth.security_utils;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uz.darkor.darkor_22.enums.AuthRole;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Getter
public class CustomUserDetails implements UserDetails {

    private Long id;
    private AuthRole role;
    private String email;
    private String password;
    private boolean blocked;
    private boolean active;
    private Set<GrantedAuthority> authorities;


    public CustomUserDetails(AuthUser user) {
        this.id = user.getId();
        this.role = user.getRole();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.blocked = user.isBlocked();
        this.active = user.isActive();
        processAuthorities(user);
    }


    private void processAuthorities(AuthUser user) {
        authorities = new HashSet<>();
        AuthRole role = user.getRole();
        if (Objects.isNull(role)) return;
        authorities.add(new SimpleGrantedAuthority(role.getValue()));
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
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
        return !this.blocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !this.active;
    }
}
