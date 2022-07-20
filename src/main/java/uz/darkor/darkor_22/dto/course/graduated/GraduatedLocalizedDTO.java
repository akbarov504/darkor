package uz.darkor.darkor_22.dto.course.graduated;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.dto.course.course.CourseLocalizationDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GraduatedLocalizedDTO extends GenericDTO {
    private Long id;
    private CourseLocalizationDTO course;

    private List<FileDTO> file;

    @Builder
    public GraduatedLocalizedDTO(@NotNull(message = "code cannot be null") UUID code,
                                 Long id,
                                 CourseLocalizationDTO course,
                                 List<FileDTO> file) {
        super(code);
        this.id = id;
        this.course = course;
        this.file = file;
    }

}
