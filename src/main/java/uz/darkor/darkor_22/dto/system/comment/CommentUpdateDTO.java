package uz.darkor.darkor_22.dto.system.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.entity.system.Gallery;

import javax.validation.constraints.NotNull;
import java.util.UUID;


@Getter
@Setter
public class CommentUpdateDTO extends GenericDTO {

    public CommentUpdateDTO( UUID code) {
        super(code);
    }

    private Byte stars;
    private String body;
    private String fullName;
    private Gallery gallery;
    private Course course;

}
