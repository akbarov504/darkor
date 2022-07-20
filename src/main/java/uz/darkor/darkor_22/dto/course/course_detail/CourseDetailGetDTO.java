package uz.darkor.darkor_22.dto.course.course_detail;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeGetDTO;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;
import uz.darkor.darkor_22.dto.course.price.PriceGetDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseDetailGetDTO extends GenericDTO {

    private Long id;

    private String titleDescriptionUz;

    private String titleDescriptionRu;

    private String titleDescriptionEn;

    private String bodyDescriptionUz;

    private String bodyDescriptionRu;

    private String bodyDescriptionEn;

    private List<FileDTO> fileUz;

    private List<FileDTO> fileRu;

    private List<FileDTO> fileEn;

    private List<EmployeeGetDTO> employees;

    private PriceGetDTO price;

    private CourseGetDTO course;

    public CourseDetailLocalizationDTO getLocalizationDto(String lang) {
        if (lang.equals("uz")) {
            return CourseDetailLocalizationDTO.builder().id(this.id).titleDescription(this.titleDescriptionUz).bodyDescription(this.bodyDescriptionUz).file(this.fileUz).course(this.course.getLocalizationDto("uz")).employees(this.employees).build();
        } else if (lang.equals("ru")) {
            return CourseDetailLocalizationDTO.builder().id(this.id).titleDescription(this.titleDescriptionRu).bodyDescription(this.bodyDescriptionRu).file(this.fileRu).course(this.course.getLocalizationDto("ru")).employees(this.employees).build();
        }
        return CourseDetailLocalizationDTO.builder().id(this.id).titleDescription(this.titleDescriptionEn).bodyDescription(this.bodyDescriptionEn).file(this.fileEn).course(this.course.getLocalizationDto("en")).employees(this.employees).build();
    }
}
