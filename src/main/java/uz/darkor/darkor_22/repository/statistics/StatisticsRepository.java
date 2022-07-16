package uz.darkor.darkor_22.repository.statistics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.darkor.darkor_22.entity.home.Carousel;
import uz.darkor.darkor_22.entity.home.Statistics;
import uz.darkor.darkor_22.repository.BaseRepository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface StatisticsRepository extends JpaRepository<Statistics, Long>, BaseRepository {

    @Transactional
    @Modifying
    @Query(value = "delete from Course where isDeleted = false and code = :code")
    Boolean deleteByCode(UUID code);

    Optional<Statistics> findByCode(UUID code);
}
