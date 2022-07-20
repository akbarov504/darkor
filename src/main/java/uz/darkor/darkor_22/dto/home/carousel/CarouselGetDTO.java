package uz.darkor.darkor_22.dto.home.carousel;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;
import uz.darkor.darkor_22.entity.system.Gallery;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CarouselGetDTO extends GenericDTO {

    private Long id;

    private FileDTO galleryUz;
    private FileDTO galleryRu;
    private FileDTO galleryEn;
    private String linkUz;
    private String linkRu;
    private String linkEn;

    public CarouselLocalizedDTO getLocalizationDto(String lang) {
        if (lang.equals("uz")) {
            return CarouselLocalizedDTO.builder().id(this.id).gallery(this.galleryEn).link(this.linkUz).build();
        } else if (lang.equals("ru")) {
            return CarouselLocalizedDTO.builder().id(this.id).gallery(this.galleryRu).link(this.linkRu).build();
        }
        return CarouselLocalizedDTO.builder().id(this.id).gallery(this.galleryEn).link(this.linkEn).build();
    }

}
