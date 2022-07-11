package uz.darkor.darkor_22.service;

import uz.darkor.darkor_22.dto.BaseDTO;
import uz.darkor.darkor_22.dto.GenericDTO;

import java.io.Serializable;

public interface GenericCUDService<CD extends BaseDTO, UD extends GenericDTO, GD extends GenericDTO, K extends Serializable> {
    GD create(CD DTO);

    GD update(UD DTO);

    Boolean delete(K key);
}
