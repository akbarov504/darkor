package uz.darkor.darkor_22.mapper.price;

import org.mapstruct.Mapper;
import uz.darkor.darkor_22.dto.course.price.PriceCreateDTO;
import uz.darkor.darkor_22.dto.course.price.PriceGetDTO;
import uz.darkor.darkor_22.dto.course.price.PriceUpdateDTO;
import uz.darkor.darkor_22.entity.course.Price;
import uz.darkor.darkor_22.mapper.GenericMapper;

@Mapper(componentModel = "spring")
public interface PriceMapper extends GenericMapper<PriceCreateDTO, PriceUpdateDTO, PriceGetDTO, Price> {
}
