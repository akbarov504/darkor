package uz.darkor.darkor_22.dto.course.course_detail;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.darkor.darkor_22.dto.BaseDTO;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeGetDTO;
import uz.darkor.darkor_22.dto.course.course.CourseCreateDTO;
import uz.darkor.darkor_22.dto.course.price.PriceCreateDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CourseDetailCreateDTO implements BaseDTO {

    private String titleDescriptionUz;

    private String titleDescriptionRu;

    private String titleDescriptionEn;

    private String bodyDescriptionUz;

    private String bodyDescriptionRu;

    private String bodyDescriptionEn;

    private List<FileDTO> fileUz;

    private List<FileDTO> fileRu;

    private List<FileDTO> fileEn;

    private PriceCreateDTO price;

    private CourseCreateDTO course;

}
