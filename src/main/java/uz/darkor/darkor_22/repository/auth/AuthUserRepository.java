package uz.darkor.darkor_22.repository.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.darkor.darkor_22.entity.auth.security_utils.AuthUser;

import java.util.Optional;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {
    Optional<Long> findIdByFullName(String toString);
}
