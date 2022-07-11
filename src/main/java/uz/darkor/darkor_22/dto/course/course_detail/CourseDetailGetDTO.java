package uz.darkor.darkor_22.dto.course.course_detail;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.entity.auth.Employee;
import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.entity.course.Skill;
import uz.darkor.darkor_22.entity.system.Gallery;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseDetailGetDTO extends GenericDTO {
    private String titleDescription;
    private String bodyDescription;
    private List<Gallery> galleries;
    private Course course;
    private List<Skill> skills;
    private List<Employee> employees;
}
