package uz.darkor.darkor_22.config.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import uz.darkor.darkor_22.repository.auth.AuthUserRepository;


import java.util.Optional;

@Component
public class SecurityAuditorAware implements AuditorAware<Long> {
    @Autowired
    private AuthUserRepository repository;

    @Override
    @NonNull
    public Optional<Long> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return repository.findIdByFullName(authentication.getPrincipal().toString());
    }

}