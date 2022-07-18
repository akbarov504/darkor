package uz.darkor.darkor_22.service.carousel;

import uz.darkor.darkor_22.criteria.carousel.CarouselCriteria;
import uz.darkor.darkor_22.criteria.course.CourseCriteria;
import uz.darkor.darkor_22.dto.course.course.CourseCreateDTO;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;
import uz.darkor.darkor_22.dto.course.course.CourseUpdateDTO;
import uz.darkor.darkor_22.dto.home.carousel.CarouselCreateDTO;
import uz.darkor.darkor_22.dto.home.carousel.CarouselGetDTO;
import uz.darkor.darkor_22.dto.home.carousel.CarouselUpdateDTO;
import uz.darkor.darkor_22.service.GenericCUDService;
import uz.darkor.darkor_22.service.GenericGLService;

import java.util.UUID;

public interface CarouselService extends GenericCUDService<CarouselCreateDTO, CarouselUpdateDTO, CarouselGetDTO, UUID>, GenericGLService<CarouselGetDTO, CarouselCriteria, UUID> {
}
