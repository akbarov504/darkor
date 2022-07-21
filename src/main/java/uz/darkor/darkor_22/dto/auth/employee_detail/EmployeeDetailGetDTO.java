package uz.darkor.darkor_22.dto.auth.employee_detail;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeGetDTO;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;
import uz.darkor.darkor_22.dto.course.skill.SkillGetDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;
import uz.darkor.darkor_22.entity.employee.Employee;
import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.entity.course.Skill;
import uz.darkor.darkor_22.entity.system.Gallery;
import uz.darkor.darkor_22.utils.BaseUtils;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class EmployeeDetailGetDTO extends GenericDTO {

    private Long id;
    private String titleDescriptionUz;

    private String titleDescriptionRu;

    private String titleDescriptionEn;

    private String bodyDescriptionUz;

    private String bodyDescriptionRu;

    private String bodyDescriptionEn;

    private List<CourseGetDTO> courses;

    private List<FileDTO> gallery;
    private EmployeeGetDTO employee;


    public EmployeeDetailLocalizedDTO getLocalizationDto() {
        String lang = BaseUtils.getSessionLang();
        return switch (lang) {
            case "en" -> EmployeeDetailLocalizedDTO.builder()
                    .code(this.getCode())
                    .id(this.getId())
                    .titleDescription(this.titleDescriptionEn)
                    .bodyDescription(this.bodyDescriptionEn)
                    .employee(this.employee.getLocalizationDto())
                    .courses(this.courses.stream()
                            .map(course1 -> course1.getLocalizationDto(lang))
                            .toList())
                    .galleries(this.gallery)
                    .build();
            case "ru" -> EmployeeDetailLocalizedDTO.builder()
                    .code(this.getCode())
                    .id(this.getId())
                    .titleDescription(this.titleDescriptionRu)
                    .bodyDescription(this.bodyDescriptionRu)
                    .employee(this.employee.getLocalizationDto())
                    .courses(this.courses.stream()
                            .map(course1 -> course1.getLocalizationDto(lang))
                            .toList())
                    .galleries(this.gallery)
                    .build();
            default -> EmployeeDetailLocalizedDTO.builder()
                    .code(this.getCode())
                    .id(this.getId())
                    .titleDescription(this.titleDescriptionUz)
                    .bodyDescription(this.bodyDescriptionUz)
                    .employee(this.employee.getLocalizationDto())
                    .courses(this.courses.stream()
                            .map(course1 -> course1.getLocalizationDto(lang))
                            .toList())
                    .galleries(this.gallery)
                    .build();

        };
    }

}
