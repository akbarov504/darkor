package uz.darkor.darkor_22.repository.homeService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.darkor.darkor_22.entity.home.HomeService;
import uz.darkor.darkor_22.entity.home.Statistics;
import uz.darkor.darkor_22.repository.BaseRepository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface HomeServiceRepository extends JpaRepository<HomeService, UUID>, BaseRepository {
    @Transactional
    @Modifying
    @Query(value = "delete from Course where isDeleted = false and code = :code")
    Boolean deleteByCode(UUID code);

    Optional<HomeService> findByCode(UUID code);
}
