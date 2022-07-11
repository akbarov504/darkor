package uz.darkor.darkor_22.dto.system.comment;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.entity.system.Gallery;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CommentGetDTO extends GenericDTO {
    private Byte stars;
    private String body;
    private String fullName;
    private Gallery gallery;
    private Course course;
}
