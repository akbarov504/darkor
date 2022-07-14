package uz.darkor.darkor_22.dto.course.graduated;

import lombok.Getter;
import lombok.Setter;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;

import java.util.UUID;

@Getter
@Setter
public class GraduatedGetDTO extends GenericDTO {
    public GraduatedGetDTO(UUID code) {
        super(code);
    }

    private CourseGetDTO course;

    private FileDTO file;


}
