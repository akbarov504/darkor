package uz.darkor.darkor_22.repository.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.darkor.darkor_22.entity.auth.security_utils.AuthUser;
import uz.darkor.darkor_22.repository.BaseRepository;

import java.util.Optional;
import java.util.UUID;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long>, BaseRepository {
    Optional<Long> findIdByFullName(String toString);

    Optional<AuthUser> findByCode(UUID key);

    @Modifying
    @Query(value = "update users us  set password =:newPassword where us.id =:id", nativeQuery = true)
    void resetPassword(@Param("newPassword") String newPassword, @Param("id") Long id);

}
