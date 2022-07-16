package uz.darkor.darkor_22.repository.system.partner;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.darkor.darkor_22.entity.system.Partner;
import uz.darkor.darkor_22.repository.BaseRepository;

import java.util.UUID;

public interface PartnerRepository extends JpaRepository<Partner, Long>, BaseRepository {

    Partner findByCode(UUID code);

    Boolean deleteByCode(UUID code);

}
