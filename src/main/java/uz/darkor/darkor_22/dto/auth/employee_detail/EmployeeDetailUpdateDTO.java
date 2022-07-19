package uz.darkor.darkor_22.dto.auth.employee_detail;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeGetDTO;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;
import uz.darkor.darkor_22.dto.course.skill.SkillGetDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;

import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDetailUpdateDTO extends GenericDTO {
    @Builder
    public EmployeeDetailUpdateDTO(UUID code,
                                   String titleDescriptionUz,
                                   String titleDescriptionRu,
                                   String titleDescriptionEn,
                                   String bodyDescriptionUz,
                                   String bodyDescriptionRu,
                                   String bodyDescriptionEn,
                                   List<CourseGetDTO> courses,
                                   List<SkillGetDTO> skills,
                                   List<FileDTO> galleries,
                                   EmployeeGetDTO employee) {
        super(code);
        this.titleDescriptionUz = titleDescriptionUz;
        this.titleDescriptionRu = titleDescriptionRu;
        this.titleDescriptionEn = titleDescriptionEn;
        this.bodyDescriptionUz = bodyDescriptionUz;
        this.bodyDescriptionRu = bodyDescriptionRu;
        this.bodyDescriptionEn = bodyDescriptionEn;
        this.courses = courses;
        this.skills = skills;
        this.galleries = galleries;
        this.employee = employee;
    }

    @Size(min = 3, max = 255, message = "The length of the name field must be between 3 and 255")
    private String titleDescriptionUz;

    @Size(min = 3, max = 255, message = "The length of the name field must be between 3 and 255")
    private String titleDescriptionRu;

    @Size(min = 3, max = 255, message = "The length of the name field must be between 3 and 255")
    private String titleDescriptionEn;

    @Size(min = 3, max = 255, message = "The length of the name field must be between 3 and 255")
    private String bodyDescriptionUz;

    @Size(min = 3, max = 255, message = "The length of the name field must be between 3 and 255")
    private String bodyDescriptionRu;

    @Size(min = 3, max = 255, message = "The length of the name field must be between 3 and 255")
    private String bodyDescriptionEn;

    private List<CourseGetDTO> courses;

    private List<SkillGetDTO> skills;

    private List<FileDTO> galleries;
    private EmployeeGetDTO employee;


}