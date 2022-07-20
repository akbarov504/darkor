package uz.darkor.darkor_22.dto.system.comment;

import lombok.*;
import uz.darkor.darkor_22.dto.BaseDTO;
import uz.darkor.darkor_22.dto.course.course.CourseLocalizationDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
public class CommentLocalizationDTO implements BaseDTO {

    private Long id;
    private Byte stars;
    private String body;
    private String fullName;
    private FileDTO gallery;
    private CourseLocalizationDTO course;

    public CommentLocalizationDTO(Long id, Byte stars, String body, String fullName, FileDTO gallery, CourseLocalizationDTO course) {
        this.id = id;
        this.stars = stars;
        this.body = body;
        this.fullName = fullName;
        this.gallery = gallery;
        this.course = course;
    }
}
