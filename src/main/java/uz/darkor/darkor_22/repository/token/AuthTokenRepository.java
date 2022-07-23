package uz.darkor.darkor_22.repository.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.darkor.darkor_22.entity.auth.token.AuthToken;
import uz.darkor.darkor_22.repository.BaseRepository;

@Repository
public interface AuthTokenRepository extends JpaRepository<AuthToken, Long>, BaseRepository {
}
