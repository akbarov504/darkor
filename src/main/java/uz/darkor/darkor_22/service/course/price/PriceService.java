package uz.darkor.darkor_22.service.course.price;

import uz.darkor.darkor_22.criteria.price.PriceCriteria;
import uz.darkor.darkor_22.dto.course.price.PriceCreateDTO;
import uz.darkor.darkor_22.dto.course.price.PriceLocalizedDTO;
import uz.darkor.darkor_22.dto.course.price.PriceUpdateDTO;
import uz.darkor.darkor_22.service.BaseService;
import uz.darkor.darkor_22.service.GenericCUDService;
import uz.darkor.darkor_22.service.GenericGLService;

import java.util.UUID;

public interface PriceService extends GenericCUDService<PriceCreateDTO, PriceUpdateDTO, PriceLocalizedDTO, UUID>, GenericGLService<PriceLocalizedDTO, PriceCriteria, UUID>, BaseService {
}
