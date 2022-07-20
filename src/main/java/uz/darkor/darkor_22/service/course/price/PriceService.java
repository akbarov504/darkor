package uz.darkor.darkor_22.service.course.price;

import uz.darkor.darkor_22.criteria.BaseCriteria;
import uz.darkor.darkor_22.criteria.price.PriceCriteria;
import uz.darkor.darkor_22.dto.course.price.PriceCreateDTO;
import uz.darkor.darkor_22.dto.course.price.PriceGetDTO;
import uz.darkor.darkor_22.dto.course.price.PriceLocalizationDTO;
import uz.darkor.darkor_22.dto.course.price.PriceUpdateDTO;
import uz.darkor.darkor_22.service.BaseService;
import uz.darkor.darkor_22.service.GenericCUDService;
import uz.darkor.darkor_22.service.GenericGLService;

import java.util.UUID;

public interface PriceService extends GenericCUDService<PriceCreateDTO, PriceUpdateDTO, PriceLocalizationDTO, UUID>, GenericGLService<PriceLocalizationDTO, PriceCriteria, UUID>, BaseService {
}
