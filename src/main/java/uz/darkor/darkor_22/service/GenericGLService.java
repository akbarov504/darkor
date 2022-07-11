package uz.darkor.darkor_22.service;

import uz.darkor.darkor_22.criteria.BaseCriteria;
import uz.darkor.darkor_22.dto.GenericDTO;

import java.io.Serializable;
import java.util.List;

public interface GenericGLService<GD extends GenericDTO, CR extends BaseCriteria, K extends Serializable> {
    GD get(K key);

    List<GD> list(CR criteria);
}
