package uz.darkor.darkor_22.dto.auth.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.darkor.darkor_22.dto.BaseDTO;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCreateDTO implements BaseDTO {

    @NotBlank(message = "full name in uz cannot be null or empty")
    private String fullNameUz;

    @NotBlank(message = "full name in ru cannot be null or empty")
    private String fullNameRu;

    @NotBlank(message = "full name in en cannot be null or empty")
    private String fullNameEn;

    @NotBlank(message = "type cannot be null or empty")
    private String type;

    @NotNull(message = "profile photo cannot be null")
    private FileDTO gallery;

    @NotNull(message = "course cannot be null")
    private List<CourseGetDTO> courses;

}
