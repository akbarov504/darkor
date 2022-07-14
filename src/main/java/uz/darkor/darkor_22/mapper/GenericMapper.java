package uz.darkor.darkor_22.mapper;

import org.mapstruct.MappingTarget;
import uz.darkor.darkor_22.dto.BaseDTO;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.entity.BaseEntity;

import java.util.List;

public interface GenericMapper<CD extends BaseDTO, UD extends GenericDTO, GD extends GenericDTO, E extends BaseEntity> extends BaseMapper {
//    CD toCreateDTO(E entity);

    E fromCreateDTO(CD createDTO);

//    UD toUpdateDTO(E entity);

    E fromUpdateDTO(UD updateDTO, @MappingTarget E entity);

    GD toGetDTO(E entity);

//    E fromGetDTO(GD DTO);

    List<GD> toListDTO(List<E> entities);

//    List<E> fromListDTO(List<GD> DTOs);
}
