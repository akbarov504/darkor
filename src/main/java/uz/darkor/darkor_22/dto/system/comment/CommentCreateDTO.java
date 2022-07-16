package uz.darkor.darkor_22.dto.system.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.darkor.darkor_22.dto.BaseDTO;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentCreateDTO implements BaseDTO {
    @NotNull(message="stars number doesn't be null")
    private Byte stars;
    @NotNull(message="body uz doesn't be null")
    private String bodyUz;
    @NotNull(message="body ru doesn't be null")
    private String bodyRu;
    @NotNull(message="body en doesn't be null")
    private String bodyEn;
    @NotNull(message="fullName uz doesn't be null")
    private String fullNameUz;
    @NotNull(message="fullName ru doesn't be null")
    private String fullNameRu;
    @NotNull(message="fullName en doesn't be null")
    private String fullNameEn;
    @NotNull(message="gallery doesn't be null")
    private FileDTO gallery;
    @NotNull(message="course doesn't be null")
    private CourseGetDTO course;
}
