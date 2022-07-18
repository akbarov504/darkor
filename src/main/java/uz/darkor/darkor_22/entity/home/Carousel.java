package uz.darkor.darkor_22.entity.home;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import uz.darkor.darkor_22.dto.home.carousel.CarouselGetDTO;
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
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Gallery galleryUz;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Gallery galleryRu;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Gallery galleryEn;

    @Column(nullable = false)
    private String linkUz;

    @Column(nullable = false)
    private String linkRu;

    @Column(nullable = false)
    private String linkEn;

    public CarouselGetDTO getLocalizationDto(String lang) {
        if (lang.equals("uz")) {
            return CarouselGetDTO.builder().code(this.getCode()).gallery(this.galleryUz).link(this.linkUz).build();
        } else if (lang.equals("ru")) {
            return CarouselGetDTO.builder().code(this.getCode()).gallery(this.galleryRu).link(this.linkRu).build();
        }
        return CarouselGetDTO.builder().code(this.getCode()).gallery(this.galleryEn).link(this.linkEn).build();
    }
}
