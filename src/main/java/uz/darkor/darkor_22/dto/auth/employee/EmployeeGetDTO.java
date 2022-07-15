package uz.darkor.darkor_22.dto.auth.employee;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.entity.system.Gallery;
import uz.darkor.darkor_22.enums.EmployeeType;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class EmployeeGetDTO extends GenericDTO {

    private String fullName;
    private EmployeeType type;
    private Gallery gallery;
    private List<Course> courses;

    @Builder
    public EmployeeGetDTO(@NotNull(message = "code cannot be null") UUID code,
                          String fullName,
                          EmployeeType type,
                          Gallery gallery,
                          List<Course> courses) {

        super(code);
        this.fullName = fullName;
        this.type = type;
        this.gallery = gallery;
        this.courses = courses;
    }
}
