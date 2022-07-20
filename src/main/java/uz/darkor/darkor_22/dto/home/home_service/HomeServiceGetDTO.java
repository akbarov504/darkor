package uz.darkor.darkor_22.dto.home.home_service;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;
import uz.darkor.darkor_22.entity.system.Gallery;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HomeServiceGetDTO extends GenericDTO {

    private  Long id;
    private FileDTO galleryUz;

    private FileDTO galleryRu;

    private FileDTO galleryEn;

    private String titleUz;

    private String titleRU;

    private String titleEn;

    private String descriptionUZ;

    private String descriptionRu;

    private String descriptionEn;

    public HomeServiceLocalizedDTO getLocalizationDto(String lang) {
        if (lang.equals("uz")) {
            return HomeServiceLocalizedDTO.builder().id(this.id).title(this.titleUz).description(this.descriptionUZ).gallery(this.galleryUz).build();
        } else if (lang.equals("ru")) {
            return HomeServiceLocalizedDTO.builder().id(this.id).title(this.titleRU).description(this.descriptionRu).gallery(this.galleryRu).build();
        }
        return HomeServiceLocalizedDTO.builder().id(this.id).title(this.titleEn).description(this.descriptionEn).gallery(this.galleryEn).build();
    }
}
