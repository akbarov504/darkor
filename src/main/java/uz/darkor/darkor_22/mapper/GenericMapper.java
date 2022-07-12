package uz.darkor.darkor_22.mapper;

import uz.darkor.darkor_22.dto.BaseDTO;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.entity.BaseEntity;

import java.util.List;

public interface GenericMapper<CD extends BaseDTO, UD extends GenericDTO, GD extends GenericDTO, E extends BaseEntity> extends BaseMapper {
    CD toCreateDTO(E DTO);

    E fromCreateDTO(CD entity);

    UD toUpdateDTO(E DTO);

    E fromUpdateDTO(UD entity);

    GD toGetDTO(E DTO);

    E fromGetDTO(GD entity);

    List<GD> toListDTO(List<E> DTO);

    List<E> fromListDTO(List<GD> entity);
}
