package uz.darkor.darkor_22.repository.auth.register;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.darkor.darkor_22.entity.auth.Register;
import uz.darkor.darkor_22.repository.BaseRepository;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Long>, BaseRepository {
}
