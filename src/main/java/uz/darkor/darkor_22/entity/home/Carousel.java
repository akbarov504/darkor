package uz.darkor.darkor_22.entity.home;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import uz.darkor.darkor_22.dto.home.carousel.CarouselGetDTO;
import uz.darkor.darkor_22.dto.home.carousel.CarouselLocalizedDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;
import uz.darkor.darkor_22.entity.Auditable;
import uz.darkor.darkor_22.entity.system.Gallery;

import javax.persistence.*;

@Getter
@Setter
@Table(indexes = @Index(name = "carousel_index", columnList = "code", unique = true))
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "is_deleted=false")
@Entity
public class Carousel extends Auditable {

    @OneToOne(cascade = CascadeType.MERGE)
    private Gallery galleryUz;

    @OneToOne(cascade = CascadeType.MERGE)
    private Gallery galleryRu;

    @OneToOne(cascade = CascadeType.MERGE)
    private Gallery galleryEn;

    @Column(nullable = false)
    private String linkUz;

    @Column(nullable = false)
    private String linkRu;

    @Column(nullable = false)
    private String linkEn;

}
