package uz.darkor.darkor_22.repository.graduated;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.darkor.darkor_22.entity.course.Graduated;
import uz.darkor.darkor_22.repository.BaseRepository;

import java.util.UUID;

public interface GraduatedRepository extends JpaRepository<Graduated, UUID>, BaseRepository {
}
