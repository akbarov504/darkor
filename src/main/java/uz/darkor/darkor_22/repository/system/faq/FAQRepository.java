package uz.darkor.darkor_22.repository.system.faq;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.darkor.darkor_22.entity.system.FAQ;
import uz.darkor.darkor_22.repository.BaseRepository;

public interface FAQRepository extends JpaRepository<FAQ, Long>, BaseRepository {
}
