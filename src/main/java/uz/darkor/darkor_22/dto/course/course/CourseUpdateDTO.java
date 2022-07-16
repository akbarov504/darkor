package uz.darkor.darkor_22.dto.course.course;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;
import uz.darkor.darkor_22.entity.system.Gallery;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseUpdateDTO extends GenericDTO {

    @NotNull(message = "id cannot be null")
    private Long id;

    @Size(min = 3, max = 255, message = "The length of the name field must be between 3 and 255")
    @NotBlank(message = "name cannot be null")
    private String nameUz;

    @Size(min = 3, max = 255, message = "The length of the name field must be between 3 and 255")
    @NotBlank(message = "name cannot be null")
    private String nameRu;

    @Size(min = 3, max = 255, message = "The length of the name field must be between 3 and 255")
    @NotBlank(message = "name cannot be null")
    private String nameEn;

    @Size(min = 10, max = 500, message = "The length of the description field must be between 10 and 500")
    @NotBlank(message = "description cannot be null")
    private String descriptionUz;

    @Size(min = 10, max = 500, message = "The length of the description field must be between 10 and 500")
    @NotBlank(message = "description cannot be null")
    private String descriptionEn;

    @Size(min = 10, max = 500, message = "The length of the description field must be between 10 and 500")
    @NotBlank(message = "description cannot be null")
    private String descriptionRu;

    @NotBlank(message = "images list cannot be null")
    private List<FileDTO> imageUz;

    @NotBlank(message = "images list cannot be null")
    private List<FileDTO> imageRu;

    @NotBlank(message = "images list cannot be null")
    private List<FileDTO> imageEn;
}
