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
public class GraduatedUpdateDTO extends GenericDTO {
    private Long id;

    private CourseGetDTO course;

    private List<FileDTO> file;

}
