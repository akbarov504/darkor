package uz.darkor.darkor_22.dto.course.course;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;
import uz.darkor.darkor_22.entity.system.Gallery;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseGetDTO extends GenericDTO {
    private Long id;
    private String name;
    private String description;
    private List<FileDTO> galleries;

    public CourseGetDTO(@NotNull(message = "code cannot be null") String code, Long id, String name, String description, List<FileDTO> galleries) {
        super(UUID.fromString(code));
        this.id = id;
        this.name = name;
        this.description = description;
        this.galleries = galleries;
    }
}
