package uz.darkor.darkor_22.dto.auth.employee;

import lombok.Getter;
import lombok.Setter;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class EmployeeUpdateDTO extends GenericDTO {
    public EmployeeUpdateDTO(UUID code) {
        super(code);
    }

    @NotBlank(message = "full name in uz cannot be null or empty")
    @Size(min = 3, max = 255, message = "The length of the name field must be between 3 and 255")
    private String fullNameUz;

    @NotBlank(message = "full name in ru cannot be null or empty")
    @Size(min = 3, max = 255, message = "The length of the name field must be between 3 and 255")
    private String fullNameRu;

    @NotBlank(message = "full name in en cannot be null or empty")
    @Size(min = 3, max = 255, message = "The length of the name field must be between 3 and 255")
    private String fullNameEn;

    @NotBlank(message = "type cannot be null or empty")
    private String type;

    @NotNull(message = "profile photo cannot be null")
    private FileDTO gallery;

    @NotNull(message = "course cannot be null")
    private List<CourseGetDTO> courses;


}
