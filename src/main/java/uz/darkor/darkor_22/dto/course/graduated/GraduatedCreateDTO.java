package uz.darkor.darkor_22.dto.course.graduated;

import lombok.*;
import uz.darkor.darkor_22.dto.BaseDTO;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GraduatedCreateDTO implements BaseDTO {
    private CourseGetDTO course;

    private List<FileDTO> file;

}
