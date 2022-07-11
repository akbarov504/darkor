package uz.darkor.darkor_22.entity.home;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.darkor.darkor_22.dto.home.carousel.CarouselGetDTO;
import uz.darkor.darkor_22.entity.Auditable;
import uz.darkor.darkor_22.entity.system.Gallery;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Carousel extends Auditable {
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Gallery galleryUz;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Gallery galleryRu;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Gallery galleryEn;

    @Column(nullable = false)
    private String link;

    public CarouselGetDTO getLocalizationDto(String lang) {
        if (lang.equals("uz")) {
            return CarouselGetDTO.builder().gallery(this.galleryUz).link(this.link).build();
        } else if (lang.equals("ru")) {
            return CarouselGetDTO.builder().gallery(this.galleryRu).link(this.link).build();
        }
        return CarouselGetDTO.builder().gallery(this.galleryEn).link(this.link).build();
    }
}
