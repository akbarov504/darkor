package uz.darkor.darkor_22.dto.auth.employee_detail;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.entity.auth.Employee;
import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.entity.course.Skill;
import uz.darkor.darkor_22.entity.system.Gallery;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDetailGetDTO extends GenericDTO {
    private String titleDescription;
    private String bodyDescription;
    private List<Gallery> galleries;
    private List<Course> courses;
    private List<Skill> skills;
    private Employee employee;

    public EmployeeDetailGetDTO(@NotNull(message = "code cannot be null") UUID code) {
        super(code);
    }
}
