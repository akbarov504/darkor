package uz.darkor.darkor_22.dto.auth.employee_detail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.darkor.darkor_22.dto.BaseDTO;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeGetDTO;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;
import uz.darkor.darkor_22.dto.course.skill.SkillGetDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;

import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetailCreateDTO implements BaseDTO {

    @NotBlank(message = "title cannot be null or empty")
    private String titleDescriptionUz;

    @NotBlank(message = "title cannot be null or empty")
    private String titleDescriptionRu;

    @NotBlank(message = "title cannot be null or empty")
    private String titleDescriptionEn;

    @NotBlank(message = "title cannot be null or empty")
    private String bodyDescriptionUz;

    @NotBlank(message = "title cannot be null or empty")
    private String bodyDescriptionRu;

    @NotBlank(message = "title cannot be null or empty")
    private String bodyDescriptionEn;

    @NotNull(message = "course cannot be null")
    private List<CourseGetDTO> courses;

    @NotBlank(message = "skill cannot be null")
    private List<SkillGetDTO> skills;

    @NotBlank(message = "gallery cannot be null")
    private List<FileDTO> gallery;

    @NotNull(message = "employee cannot be null")
    private EmployeeGetDTO employee;

}