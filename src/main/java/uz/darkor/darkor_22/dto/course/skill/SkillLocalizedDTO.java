package uz.darkor.darkor_22.dto.course.skill;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.dto.course.course.CourseLocalizationDTO;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SkillLocalizedDTO extends GenericDTO {
    private Long id;
    private String name;
    private String description;

    private CourseLocalizationDTO course;

    @Builder
    public SkillLocalizedDTO(UUID code, Long id, String name, String description, CourseLocalizationDTO course) {
        super(code);
        this.id = id;
        this.name = name;
        this.description = description;
        this.course = course;
    }
}
