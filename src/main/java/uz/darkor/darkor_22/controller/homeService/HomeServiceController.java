package uz.darkor.darkor_22.controller.homeService;

import uz.darkor.darkor_22.controller.GenericCUDController;
import uz.darkor.darkor_22.controller.GenericGLController;
import uz.darkor.darkor_22.criteria.homeService.HomeServiceCriteria;
import uz.darkor.darkor_22.dto.home.home_service.HomeServiceCreateDTO;
import uz.darkor.darkor_22.dto.home.home_service.HomeServiceGetDTO;
import uz.darkor.darkor_22.dto.home.home_service.HomeServiceUpdateDTO;

import java.util.UUID;

public interface HomeServiceController extends GenericCUDController<HomeServiceCreateDTO, HomeServiceUpdateDTO, HomeServiceGetDTO, UUID>, GenericGLController<HomeServiceGetDTO, HomeServiceCriteria,UUID> {
}
