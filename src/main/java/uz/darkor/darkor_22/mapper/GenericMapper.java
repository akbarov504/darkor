package uz.darkor.darkor_22.mapper;

import uz.darkor.darkor_22.dto.BaseDTO;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.entity.BaseEntity;

import java.util.List;

public interface GenericMapper<CD extends BaseDTO, UD extends GenericDTO, GD extends GenericDTO, E extends BaseEntity> extends BaseMapper {
    E toCreateDTO(CD DTO);

    CD fromCreateDTO(E entity);

    E toUpdateDTO(UD DTO);

    UD fromUpdateDTO(E entity);

    E toGetDTO(GD DTO);

    GD fromGetDTO(E entity);

    List<E> toListDTO(List<GD> DTO);

    List<GD> fromListDTO(List<E> entity);
}
