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
    private String name;
    private String description;
    private CourseGetDTO course;

    @Builder
    public SkillGetDTO(@NotNull(message = "code cannot be null") UUID code,
                       String name,
                       String description,
                       Course course) {
        super(code);
        this.name = name;
        this.description = description;
        this.course = course.getLocalizationDto(BaseUtils.getSessionLang());
    }
}
