package uz.darkor.darkor_22.dto.auth.employee_detail;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeGetDTO;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeLocalizedDTO;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;
import uz.darkor.darkor_22.dto.course.course.CourseLocalizationDTO;
import uz.darkor.darkor_22.dto.course.skill.SkillGetDTO;
import uz.darkor.darkor_22.dto.course.skill.SkillLocalizedDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDetailLocalizedDTO extends GenericDTO {

    private Long id;
    private String titleDescription;
    private String bodyDescription;

    private List<FileDTO> galleries;
    private List<CourseLocalizationDTO> courses;
    private EmployeeLocalizedDTO employee;

    @Builder
    public EmployeeDetailLocalizedDTO(UUID code,
                                      Long id,
                                      String titleDescription,
                                      String bodyDescription,
                                      List<FileDTO> galleries,
                                      List<CourseLocalizationDTO> courses,
                                      EmployeeLocalizedDTO employee) {
        super(code);
        this.id = id;
        this.titleDescription = titleDescription;
        this.bodyDescription = bodyDescription;
        this.galleries = galleries;
        this.courses = courses;
        this.employee = employee;
    }


}
