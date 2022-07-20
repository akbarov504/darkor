package uz.darkor.darkor_22.service.course.course;

import uz.darkor.darkor_22.criteria.course.CourseDetailCriteria;
import uz.darkor.darkor_22.dto.course.course_detail.CourseDetailCreateDTO;
import uz.darkor.darkor_22.dto.course.course_detail.CourseDetailLocalizationDTO;
import uz.darkor.darkor_22.dto.course.course_detail.CourseDetailUpdateDTO;
import uz.darkor.darkor_22.service.GenericCUDService;
import uz.darkor.darkor_22.service.GenericGLService;

public interface CourseDetailsService extends GenericCUDService<CourseDetailCreateDTO, CourseDetailUpdateDTO, CourseDetailLocalizationDTO, Long>,
        GenericGLService<CourseDetailLocalizationDTO, CourseDetailCriteria, Long> {

}