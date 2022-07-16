package uz.darkor.darkor_22.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.darkor.darkor_22.entity.auth.Employee;
import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.repository.BaseRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, BaseRepository {
    Optional<Employee> findByCode(UUID code);

    boolean deleteByCode(UUID key);

    @Query("from Employee where courses = :course and type = :type")
    List<Employee> findAllByCoursesAndType(@Param("course") List<Course> course, @Param("type") String type);
}
