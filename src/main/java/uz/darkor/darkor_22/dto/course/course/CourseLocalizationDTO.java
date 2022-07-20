package uz.darkor.darkor_22.dto.course.course;

import lombok.*;
import uz.darkor.darkor_22.dto.BaseDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseLocalizationDTO implements BaseDTO {

    private Long id;
    private String name;
    private String description;
    private List<FileDTO> galleries;

}
