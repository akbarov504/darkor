package uz.darkor.darkor_22.service.homeService;

import uz.darkor.darkor_22.criteria.homeService.HomeServiceCriteria;
import uz.darkor.darkor_22.dto.home.home_service.HomeServiceCreateDTO;
import uz.darkor.darkor_22.dto.home.home_service.HomeServiceGetDTO;
import uz.darkor.darkor_22.dto.home.home_service.HomeServiceUpdateDTO;
import uz.darkor.darkor_22.entity.home.HomeService;
import uz.darkor.darkor_22.service.GenericCUDService;
import uz.darkor.darkor_22.service.GenericGLService;

import java.util.UUID;

public interface HomeSerService extends GenericCUDService<HomeServiceCreateDTO, HomeServiceUpdateDTO, HomeServiceGetDTO, UUID>, GenericGLService<HomeServiceGetDTO, HomeServiceCriteria,UUID> {
}
