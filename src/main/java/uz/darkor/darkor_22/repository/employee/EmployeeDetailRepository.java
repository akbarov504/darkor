package uz.darkor.darkor_22.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.darkor.darkor_22.entity.auth.EmployeeDetail;
import uz.darkor.darkor_22.repository.BaseRepository;

import java.util.Optional;
import java.util.UUID;

public interface EmployeeDetailRepository extends JpaRepository<EmployeeDetail, Long>, BaseRepository {
    Optional<EmployeeDetail> findByCode(UUID code);

    boolean deleteByCode(UUID code);
}
