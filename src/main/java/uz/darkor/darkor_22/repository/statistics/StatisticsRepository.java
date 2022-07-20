package uz.darkor.darkor_22.repository.statistics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.darkor.darkor_22.entity.home.Statistics;
import uz.darkor.darkor_22.repository.BaseRepository;

@Repository
public interface StatisticsRepository extends JpaRepository<Statistics, Long>, BaseRepository {

}
