package uz.darkor.darkor_22.dto.course.graduated;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GraduatedGetDTO extends GenericDTO {
    private Long id;

    private CourseGetDTO course;

    private List<FileDTO> file;

    public GraduatedLocalizedDTO getLocalizationDto(String lang) {
        return GraduatedLocalizedDTO.builder().code(this.getCode()).
                id(this.id).
                course(this.course.getLocalizationDto(lang))
                .file(this.file)
                .build();

    }
}
