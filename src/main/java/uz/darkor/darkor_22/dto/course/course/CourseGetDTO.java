package uz.darkor.darkor_22.dto.course.course;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseGetDTO extends GenericDTO {

    private Long id;

    private String nameUz;

    private String nameRu;

    private String nameEn;

    private String descriptionUz;

    private String descriptionEn;

    private String descriptionRu;

    private List<FileDTO> imageUz;
    private List<FileDTO> imageRu;
    private List<FileDTO> imageEn;

    public CourseLocalizationDTO getLocalizationDto(String lang) {
        if (lang.equals("uz")) {
            return CourseLocalizationDTO.builder().id(getId()).code(getCode()).name(this.nameUz).description(this.descriptionUz).galleries(this.imageUz).build();
        } else if (lang.equals("ru")) {
            return CourseLocalizationDTO.builder().id(getId()).code(getCode()).name(this.nameRu).description(this.descriptionRu).galleries(this.imageRu).build();
        }
        return CourseLocalizationDTO.builder().id(getId()).code(getCode()).name(this.nameEn).description(this.descriptionEn).galleries(this.imageEn).build();
    }
}
