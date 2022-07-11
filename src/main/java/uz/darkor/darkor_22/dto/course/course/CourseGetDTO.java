package uz.darkor.darkor_22.dto.course.course;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.entity.system.Gallery;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseGetDTO extends GenericDTO {
    private String name;
    private String description;
    private List<Gallery> galleries;
}
