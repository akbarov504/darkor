package uz.darkor.darkor_22.dto.auth.employee;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;
import uz.darkor.darkor_22.dto.course.course.CourseLocalizationDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;
import uz.darkor.darkor_22.entity.system.Gallery;
import uz.darkor.darkor_22.enums.EmployeeType;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
public class EmployeeLocalizedDTO extends GenericDTO {

    private Long id;
    private String fullName;
    private EmployeeType type;
    private FileDTO gallery;
    private List<CourseLocalizationDTO> courses;

    @Builder
    public EmployeeLocalizedDTO(UUID code,
                                Long id,
                                String fullName,
                                EmployeeType type,
                                FileDTO gallery,
                                List<CourseLocalizationDTO> courses) {
        super(code);
        this.id = id;
        this.fullName = fullName;
        this.type = type;
        this.gallery = gallery;
        this.courses = courses;
    }
}
