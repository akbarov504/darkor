package uz.darkor.darkor_22.controller.course.course;

import uz.darkor.darkor_22.controller.GenericCUDController;
import uz.darkor.darkor_22.controller.GenericGLController;
import uz.darkor.darkor_22.criteria.course.CourseCriteria;
import uz.darkor.darkor_22.dto.course.course.CourseCreateDTO;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;
import uz.darkor.darkor_22.dto.course.course.CourseUpdateDTO;

import java.util.UUID;

public interface CourseController extends GenericCUDController<CourseCreateDTO, CourseUpdateDTO, CourseGetDTO, UUID>, GenericGLController<CourseGetDTO, CourseCriteria, UUID> {
}
