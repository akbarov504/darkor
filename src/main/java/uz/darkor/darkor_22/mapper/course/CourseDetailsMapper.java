package uz.darkor.darkor_22.mapper.course;

import org.mapstruct.Mapper;
import uz.darkor.darkor_22.dto.course.course_detail.CourseDetailCreateDTO;
import uz.darkor.darkor_22.dto.course.course_detail.CourseDetailGetDTO;
import uz.darkor.darkor_22.dto.course.course_detail.CourseDetailUpdateDTO;
import uz.darkor.darkor_22.entity.course.CourseDetail;
import uz.darkor.darkor_22.mapper.GenericMapper;
import uz.darkor.darkor_22.mapper.employee.EmployeeMapper;
import uz.darkor.darkor_22.mapper.price.PriceMapper;
import uz.darkor.darkor_22.mapper.system.file.FileMapper;

@Mapper(componentModel = "spring", uses = {FileMapper.class, EmployeeMapper.class, PriceMapper.class, CourseMapper.class})
public interface CourseDetailsMapper extends GenericMapper<CourseDetailCreateDTO, CourseDetailUpdateDTO, CourseDetailGetDTO, CourseDetail> {

    CourseDetailUpdateDTO toUpdateDTO(CourseDetail entity);

}
