package uz.darkor.darkor_22.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.darkor.darkor_22.entity.auth.AuthUser;
import uz.darkor.darkor_22.repository.BaseRepository;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Long>, BaseRepository {
    AuthUser findByEmail(String email);
}
