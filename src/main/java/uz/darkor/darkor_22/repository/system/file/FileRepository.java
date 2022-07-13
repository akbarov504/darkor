package uz.darkor.darkor_22.repository.system.file;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.darkor.darkor_22.entity.system.Gallery;
import uz.darkor.darkor_22.repository.BaseRepository;

public interface FileRepository extends JpaRepository<Gallery, Long>, BaseRepository {



}
