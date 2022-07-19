package uz.darkor.darkor_22.dto.auth.employee_detail;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeGetDTO;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;
import uz.darkor.darkor_22.dto.course.skill.SkillGetDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;
import uz.darkor.darkor_22.entity.auth.Employee;
import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.entity.course.Skill;
import uz.darkor.darkor_22.entity.system.Gallery;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class EmployeeDetailGetDTO extends GenericDTO {

    private String titleDescription;
    private String bodyDescription;

    private List<FileDTO> galleries;
    private List<CourseGetDTO> courses;
    private List<SkillGetDTO> skills;
    private EmployeeGetDTO employee;

    @Builder
    public EmployeeDetailGetDTO(UUID code,
                                String titleDescription,
                                String bodyDescription,
                                List<FileDTO> galleries,
                                List<CourseGetDTO> courses,
                                List<SkillGetDTO> skills,
                                EmployeeGetDTO employee) {
        super(code);
        this.titleDescription = titleDescription;
        this.bodyDescription = bodyDescription;
        this.galleries = galleries;
        this.courses = courses;
        this.skills = skills;
        this.employee = employee;
    }
}
