package uz.darkor.darkor_22.dto.course.skill;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.entity.course.Course;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SkillGetDTO extends GenericDTO {
    private String name;
    private String description;
    private Course course;
}
