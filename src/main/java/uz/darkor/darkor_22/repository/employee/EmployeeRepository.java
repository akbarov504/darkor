package uz.darkor.darkor_22.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.darkor.darkor_22.entity.auth.Employee;
import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.enums.EmployeeType;
import uz.darkor.darkor_22.repository.BaseRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, BaseRepository {
    Optional<Employee> findByCode(UUID code);

    boolean deleteByCode(UUID key);

    List<Employee> findAllByCoursesAndType(List<Course> courses, EmployeeType type);
}
