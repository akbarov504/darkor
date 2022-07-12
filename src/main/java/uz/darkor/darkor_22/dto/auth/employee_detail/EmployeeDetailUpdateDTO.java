package uz.darkor.darkor_22.dto.auth.employee_detail;

import lombok.Getter;
import lombok.Setter;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeGetDTO;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;
import uz.darkor.darkor_22.dto.course.skill.SkillGetDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;

import java.util.List;
import java.util.UUID;


@Getter
@Setter
public class EmployeeDetailUpdateDTO extends GenericDTO {
    public EmployeeDetailUpdateDTO(UUID code) {
        super(code);
    }

    private String titleDescriptionUz;

    private String titleDescriptionRu;

    private String titleDescriptionEn;

    private String bodyDescriptionUz;

    private String bodyDescriptionRu;

    private String bodyDescriptionEn;

    private List<CourseGetDTO> courses;

    private List<SkillGetDTO> skills;

    private List<FileDTO> gallery;

    private EmployeeGetDTO employee;

}