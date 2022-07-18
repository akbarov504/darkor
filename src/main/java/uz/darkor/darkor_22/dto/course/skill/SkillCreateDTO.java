package uz.darkor.darkor_22.dto.course.skill;

import lombok.Getter;
import lombok.Setter;
import uz.darkor.darkor_22.dto.BaseDTO;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Getter
@Setter
public class SkillCreateDTO implements BaseDTO {

    @NotBlank(message = "name uz cannot be null or empty")
    @Size(min = 3, max = 255,
            message = "The length of the name field must be between 3 and 255")
    private String nameUZ;

    @NotBlank(message = "name ru cannot be null or empty")
    @Size(min = 3, max = 255,
            message = "The length of the name field must be between 3 and 255")
    private String nameRu;

    @NotBlank(message = "name en cannot be null or empty")
    @Size(min = 3, max = 255,
            message = "The length of the name field must be between 3 and 255")
    private String nameEn;

    @NotBlank(message = "description uz cannot be null or empty")
    @Size(min = 3, max = 255,
            message = "The length of the name field must be between 3 and 255")
    private String descriptionUz;

    @NotBlank(message = "description ru cannot be null or empty")
    @Size(min = 3, max = 255,
            message = "The length of the name field must be between 3 and 255")
    private String descriptionRu;

    @NotBlank(message = "description en cannot be null or empty")
    @Size(min = 3, max = 255,
            message = "The length of the name field must be between 3 and 255")
    private String descriptionEn;

    @NotNull(message = "course cannot be null")
    private CourseGetDTO course;
}
