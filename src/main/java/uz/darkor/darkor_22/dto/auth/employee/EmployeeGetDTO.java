package uz.darkor.darkor_22.dto.auth.employee;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.dto.auth.employee_detail.EmployeeDetailGetDTO;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;
import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.entity.system.Gallery;
import uz.darkor.darkor_22.enums.EmployeeType;
import uz.darkor.darkor_22.utils.BaseUtils;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeGetDTO extends GenericDTO {

    private Long id;

    private String fullNameUz;

    private String fullNameRu;

    private String fullNameEn;

    private EmployeeType type;

    private FileDTO gallery;

    private List<CourseGetDTO> courses;


    public EmployeeLocalizedDTO getLocalizationDto() {
        String lang = BaseUtils.getSessionLang();
        return switch (lang) {
            case "en" -> EmployeeLocalizedDTO.builder()
                    .code(this.getCode())
                    .id(this.getId())
                    .fullName(this.fullNameEn)
                    .type(this.type)
                    .gallery(this.gallery)
                    .courses(this.courses.stream()
                            .map(courseGetDTO -> courseGetDTO.getLocalizationDto(lang))
                            .toList())
                    .build();
            case "ru" -> EmployeeLocalizedDTO.builder()
                    .code(this.getCode())
                    .id(this.getId())
                    .fullName(this.fullNameRu)
                    .type(this.type)
                    .gallery(this.gallery)
                    .courses(this.courses.stream()
                            .map(courseGetDTO -> courseGetDTO.getLocalizationDto(lang))
                            .toList())
                    .build();
            default -> EmployeeLocalizedDTO.builder()
                    .code(this.getCode())
                    .id(this.getId())
                    .fullName(this.fullNameUz)
                    .type(this.type)
                    .gallery(this.gallery)
                    .courses(this.courses.stream()
                            .map(courseGetDTO -> courseGetDTO.getLocalizationDto(lang))
                            .toList())
                    .build();
        };
    }
}
