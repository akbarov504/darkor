package uz.darkor.darkor_22.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.darkor.darkor_22.entity.auth.Employee;
import uz.darkor.darkor_22.repository.BaseRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, BaseRepository {
}
