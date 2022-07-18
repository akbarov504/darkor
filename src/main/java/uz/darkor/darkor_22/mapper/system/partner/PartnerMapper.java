package uz.darkor.darkor_22.mapper.system.partner;

import org.mapstruct.Mapper;
import uz.darkor.darkor_22.dto.system.partner.PartnerCreateDTO;
import uz.darkor.darkor_22.dto.system.partner.PartnerGetDTO;
import uz.darkor.darkor_22.dto.system.partner.PartnerUpdateDTO;
import uz.darkor.darkor_22.entity.system.Partner;
import uz.darkor.darkor_22.mapper.GenericMapper;
import uz.darkor.darkor_22.mapper.system.file.FileMapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {FileMapper.class})
public interface PartnerMapper extends GenericMapper<PartnerCreateDTO, PartnerUpdateDTO, PartnerGetDTO, Partner> {

    @Override
    Partner fromCreateDTO(PartnerCreateDTO createDTO);

//    @Override
//    Partner fromUpdateDTO(PartnerUpdateDTO updateDTO, Partner entity);

    @Override
    PartnerGetDTO toGetDTO(Partner entity);

    @Override
    List<PartnerGetDTO> toListDTO(List<Partner> entities);
}
