package uz.darkor.darkor_22.dto.auth.employee;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.entity.system.Gallery;
import uz.darkor.darkor_22.enums.EmployeeType;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
//@NoArgsConstructor
//@AllArgsConstructor
public class EmployeeGetDTO extends GenericDTO {

    public EmployeeGetDTO(UUID code) {
        super(code);
    }

    private String fullName;
    private EmployeeType type;
    private Gallery gallery;
    private List<Course> courses;
}
