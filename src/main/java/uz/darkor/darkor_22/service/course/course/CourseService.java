package uz.darkor.darkor_22.service.course.course;

import uz.darkor.darkor_22.criteria.course.CourseCriteria;
import uz.darkor.darkor_22.dto.course.course.CourseCreateDTO;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;
import uz.darkor.darkor_22.dto.course.course.CourseUpdateDTO;
import uz.darkor.darkor_22.service.GenericCUDService;
import uz.darkor.darkor_22.service.GenericGLService;

import java.util.UUID;

public interface CourseService extends GenericCUDService<CourseCreateDTO, CourseUpdateDTO, CourseGetDTO, UUID>, GenericGLService<CourseGetDTO, CourseCriteria, UUID> {
}
