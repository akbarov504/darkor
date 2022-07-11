package uz.darkor.darkor_22.repository.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.repository.BaseRepository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>, BaseRepository {
    @Transactional
    @Modifying
    @Query(value = "delete from Course where isDeleted = false and code = :code")
    Boolean deleteByCode(UUID code);

    @Query(value = "from Course where isDeleted = false and code = :code")
    Course findByCode(UUID code);
}
