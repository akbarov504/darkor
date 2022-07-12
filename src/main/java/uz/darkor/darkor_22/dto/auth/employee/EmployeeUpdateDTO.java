package uz.darkor.darkor_22.dto.auth.employee;

import lombok.Getter;
import lombok.Setter;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class EmployeeUpdateDTO extends GenericDTO {
    public EmployeeUpdateDTO(UUID code) {
        super(code);
    }

    private String fullNameUz;

    private String fullNameRu;

    private String fullNameEn;

    private String type;

    private FileDTO gallery;

    private List<CourseGetDTO> courses;


}
