package uz.darkor.darkor_22.dto.home.post;

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
public class PostGetDTO extends GenericDTO {

    private Long id;
    private FileDTO galleryUz;

    private FileDTO galleryRu;

    private FileDTO galleryEn;

    private String titleUz;

    private String titleRu;

    private String titleEn;

    private String descriptionUz;

    private String descriptionRu;

    private String descriptionEn;

    public PostLocalizedDTO getLocalizationDto(String lang) {

        if (lang.equals("uz")) {
            return PostLocalizedDTO.builder().id(this.id).title(this.titleUz).description(this.descriptionUz).gallery(this.galleryUz).build();
        } else if (lang.equals("ru")) {
            return PostLocalizedDTO.builder().id(this.id).title(this.titleRu).description(this.descriptionRu).gallery(this.galleryRu).build();
        }
        return PostLocalizedDTO.builder().id(this.id).title(this.titleEn).description(this.descriptionEn).gallery(this.galleryEn).build();

    }
}
