package uz.darkor.darkor_22.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.darkor.darkor_22.criteria.BaseCriteria;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.response.Data;
import uz.darkor.darkor_22.utils.BaseUtils;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

public interface GenericGLController<GD extends GenericDTO, CR extends BaseCriteria, K extends Serializable> {
    @RequestMapping(value = BaseUtils.GET_PATH, method = RequestMethod.GET)
    ResponseEntity<Data<GD>> get( @PathVariable K code, @RequestHeader("accept-language") String lang);

    @RequestMapping(value = BaseUtils.LIST_PATH, method = RequestMethod.GET)
    ResponseEntity<Data<List<GD>>> list(@Valid CR criteria, @RequestHeader("accept-language") String lang);
}
