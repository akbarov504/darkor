package uz.darkor.darkor_22.mapper.homeService;


import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.darkor.darkor_22.dto.home.home_service.HomeServiceCreateDTO;
import uz.darkor.darkor_22.dto.home.home_service.HomeServiceGetDTO;
import uz.darkor.darkor_22.dto.home.home_service.HomeServiceUpdateDTO;
import uz.darkor.darkor_22.entity.home.HomeService;
import uz.darkor.darkor_22.mapper.GenericMapper;
import uz.darkor.darkor_22.mapper.system.file.FileMapper;

import java.util.UUID;

@Mapper(componentModel = "spring", uses = {FileMapper.class})
public interface HomeServiceMapper extends GenericMapper<HomeServiceCreateDTO, HomeServiceUpdateDTO, HomeServiceGetDTO, HomeService> {
}
