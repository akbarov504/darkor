package uz.darkor.darkor_22.entity.home;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import uz.darkor.darkor_22.dto.home.home_service.HomeServiceGetDTO;
import uz.darkor.darkor_22.entity.Auditable;
import uz.darkor.darkor_22.entity.system.Gallery;

import javax.persistence.*;

@Getter
@Setter
@Table(indexes = @Index(name = "homeService_index", columnList = "code", unique = true))
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "is_deleted=false")
@Entity
public class HomeService extends Auditable {

    @OneToOne(cascade = CascadeType.MERGE)
    private Gallery galleryUz;

    @OneToOne(cascade = CascadeType.MERGE)
    private Gallery galleryRu;

    @OneToOne(cascade = CascadeType.MERGE)
    private Gallery galleryEn;

    @Column(nullable = false)
    private String titleUz;

    @Column(nullable = false)
    private String titleRU;

    @Column(nullable = false)
    private String titleEn;

    @Column(nullable = false)
    private String descriptionUZ;

    @Column(nullable = false)
    private String descriptionRu;

    @Column(nullable = false)
    private String descriptionEn;


}
