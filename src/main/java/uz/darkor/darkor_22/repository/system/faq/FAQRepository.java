package uz.darkor.darkor_22.repository.system.faq;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.darkor.darkor_22.entity.system.FAQ;
import uz.darkor.darkor_22.repository.BaseRepository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface FAQRepository extends JpaRepository<FAQ, Long>, BaseRepository {
    Optional<FAQ> findByCode(UUID code);
}
