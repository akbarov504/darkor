package uz.darkor.darkor_22.dto.course.course_detail;

import lombok.*;
import uz.darkor.darkor_22.dto.BaseDTO;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeGetDTO;
import uz.darkor.darkor_22.dto.course.course.CourseUpdateDTO;
import uz.darkor.darkor_22.dto.course.price.PriceUpdateDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;

import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.entity.course.Price;
import uz.darkor.darkor_22.entity.course.Skill;
import uz.darkor.darkor_22.entity.system.Comment;
import uz.darkor.darkor_22.entity.system.FAQ;
import uz.darkor.darkor_22.entity.system.Gallery;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDetailUpdateDTO extends  GenericDTO {

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

    private PriceUpdateDTO price;

    private CourseUpdateDTO course;



}
