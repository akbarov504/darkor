package uz.darkor.darkor_22.mapper.course;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.darkor.darkor_22.dto.course.course.CourseCreateDTO;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;
import uz.darkor.darkor_22.dto.course.course.CourseUpdateDTO;
import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.mapper.GenericMapper;

@Component
@Mapper(componentModel = "spring")
public interface CourseMapper extends GenericMapper<CourseCreateDTO, CourseUpdateDTO, CourseGetDTO, Course> {
}
