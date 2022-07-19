package uz.darkor.darkor_22.repository.price;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.entity.course.CourseDetail;
import uz.darkor.darkor_22.entity.course.Price;
import uz.darkor.darkor_22.repository.BaseRepository;

import java.util.Optional;
import java.util.UUID;


public interface PriceRepository extends JpaRepository<Price, Long>, BaseRepository {
    Optional<Price> findByCode(UUID code);

    Boolean deleteByCode(UUID key);
}
