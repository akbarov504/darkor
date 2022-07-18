package uz.darkor.darkor_22.repository.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.darkor.darkor_22.entity.home.HomeService;
import uz.darkor.darkor_22.entity.home.Post;
import uz.darkor.darkor_22.repository.BaseRepository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>, BaseRepository {

    @Transactional
    @Modifying
    @Query(value = "delete from Course where isDeleted = false and code = :code")
    Boolean deleteByCode(UUID code);

    Optional<Post> findByCode(UUID code);
}
