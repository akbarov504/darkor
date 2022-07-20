package uz.darkor.darkor_22.controller.course.course.courseDetails;

import uz.darkor.darkor_22.controller.GenericCUDController;
import uz.darkor.darkor_22.controller.GenericGLController;
import uz.darkor.darkor_22.criteria.course.CourseDetailCriteria;
import uz.darkor.darkor_22.dto.course.course_detail.CourseDetailCreateDTO;
import uz.darkor.darkor_22.dto.course.course_detail.CourseDetailGetDTO;
import uz.darkor.darkor_22.dto.course.course_detail.CourseDetailUpdateDTO;

public interface CourseDetailController extends GenericCUDController<CourseDetailCreateDTO, CourseDetailUpdateDTO, CourseDetailGetDTO, Long>,
        GenericGLController<CourseDetailGetDTO, CourseDetailCriteria, Long> {
}
