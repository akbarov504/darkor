package uz.darkor.darkor_22.dto.course.skill;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;
import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.utils.BaseUtils;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SkillGetDTO extends GenericDTO {
    private Long id;
    private String name;
    private String description;
    private Course course;

    @Builder
    public SkillGetDTO(UUID code, Long id, String name, String description, Course course) {
        super(code);
        this.id = id;
        this.name = name;
        this.description = description;
        this.course = course;
    }

    public SkillLocalizedDTO getLocalizationDto() {
        return null;
    }
}
