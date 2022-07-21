package uz.darkor.darkor_22.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.darkor.darkor_22.entity.employee.Employee;
import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.repository.BaseRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, BaseRepository {
    Optional<Employee> findByCode(UUID code);

    @Modifying
    @Query(value = "delete from Employee where code = :key")
    void deleteByCode(@Param("key") UUID key);

    @Query(value = "select * from employee  e" +
            "    inner join employee_courses ec" +
            "        on  ec.courses_id = :course" +
            "            and e.type = 'EXPERT'",nativeQuery = true)
    List<Employee> findAllByCourses(@Param("course")Long courseId);
}
