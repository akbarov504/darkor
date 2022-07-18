package uz.darkor.darkor_22.controller.carousel;

import org.springframework.http.ResponseEntity;
import uz.darkor.darkor_22.controller.GenericCUDController;


import uz.darkor.darkor_22.controller.GenericGLController;
import uz.darkor.darkor_22.criteria.carousel.CarouselCriteria;
import uz.darkor.darkor_22.dto.home.carousel.CarouselCreateDTO;
import uz.darkor.darkor_22.dto.home.carousel.CarouselGetDTO;
import uz.darkor.darkor_22.dto.home.carousel.CarouselUpdateDTO;

import java.util.UUID;


public interface CarouselController extends GenericCUDController<CarouselCreateDTO, CarouselUpdateDTO, CarouselGetDTO, UUID>, GenericGLController<CarouselGetDTO, CarouselCriteria,UUID> {

}
