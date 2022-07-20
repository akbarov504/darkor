package uz.darkor.darkor_22.dto.course.course_detail;

import lombok.*;
import uz.darkor.darkor_22.dto.BaseDTO;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeGetDTO;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;
import uz.darkor.darkor_22.dto.course.course.CourseLocalizationDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseDetailLocalizationDTO implements BaseDTO {

 private Long id;
 private String titleDescription;
 private String bodyDescription;
 private List<FileDTO> file;
// private PriceLocalizationDTO  todo price Localiztion dto ni qo'shish
 private CourseLocalizationDTO course;
 private List<EmployeeGetDTO> employees;

}
