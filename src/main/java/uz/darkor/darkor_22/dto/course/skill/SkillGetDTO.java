package uz.darkor.darkor_22.dto.course.skill;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;
import uz.darkor.darkor_22.dto.course.course.CourseLocalizationDTO;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SkillGetDTO extends GenericDTO {
    private Long id;
    private String nameUz;


    private String nameRu;


    private String nameEn;
    private String descriptionUz;

    private String descriptionRu;
    private String descriptionEn;

    private CourseGetDTO course;

    public SkillLocalizedDTO getLocalizationDto(String lang) {
        return switch (lang) {
            case "en" -> SkillLocalizedDTO.builder().code(this.getCode()).
                    id(this.id).
                    name(this.nameEn)
                    .description(this.descriptionEn)
                    .course(this.course.getLocalizationDto(lang))
                    .build();
            case "ru" -> SkillLocalizedDTO.builder().code(this.getCode()).
                    id(this.id).
                    name(this.nameRu)
                    .description(this.descriptionRu)
                    .course(this.course.getLocalizationDto(lang))
                    .build();
            default -> SkillLocalizedDTO.builder().code(this.getCode()).
                    id(this.id).
                    name(this.nameUz)
                    .description(this.descriptionUz)
                    .course(this.course.getLocalizationDto(lang))
                    .build();
        };
    }
}
