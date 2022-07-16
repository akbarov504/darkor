package uz.darkor.darkor_22.dto.course.graduated;

import lombok.Getter;
import lombok.Setter;
import uz.darkor.darkor_22.dto.BaseDTO;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;

@Getter
@Setter
public class GraduatedCreateDTO implements BaseDTO {

    private CourseGetDTO course;

    private FileDTO file;

}
