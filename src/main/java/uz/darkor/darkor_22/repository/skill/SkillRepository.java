package uz.darkor.darkor_22.repository.skill;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.darkor.darkor_22.entity.auth.EmployeeDetail;
import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.entity.course.Skill;
import uz.darkor.darkor_22.repository.BaseRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SkillRepository extends JpaRepository<Skill, Long>, BaseRepository {
    Optional<Skill> findByCode(UUID code);

    Boolean deleteByCode(UUID key);

    List<Skill> findByCourse(Course course);
}
