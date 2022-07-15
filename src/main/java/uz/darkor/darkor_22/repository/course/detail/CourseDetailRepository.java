package uz.darkor.darkor_22.repository.course.detail;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.darkor.darkor_22.entity.course.CourseDetail;

import java.util.Optional;
import java.util.UUID;


public interface CourseDetailRepository extends JpaRepository<CourseDetail, UUID> {

    Optional<CourseDetail> findByCode(UUID code);
}
