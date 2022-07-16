package uz.darkor.darkor_22.controller.course.price;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.darkor.darkor_22.controller.AbstractController;
import uz.darkor.darkor_22.criteria.BaseCriteria;
import uz.darkor.darkor_22.dto.course.price.PriceCreateDTO;
import uz.darkor.darkor_22.dto.course.price.PriceGetDTO;
import uz.darkor.darkor_22.dto.course.price.PriceUpdateDTO;
import uz.darkor.darkor_22.response.Data;
import uz.darkor.darkor_22.service.course.price.PriceService;
import uz.darkor.darkor_22.utils.BaseUtils;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(BaseUtils.PATH + "/price/*")
public class PriceControllerImpl extends AbstractController<PriceService> implements PriceController {

    public PriceControllerImpl(PriceService service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<PriceGetDTO>> create(PriceCreateDTO DTO) {
        return new ResponseEntity<>(new Data<>(service.create(DTO)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<PriceGetDTO>> update(PriceUpdateDTO DTO) {
        return new ResponseEntity<>(new Data<>(service.update(DTO)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(UUID code) {
        return new ResponseEntity<>(new Data<>(service.delete(code)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<PriceGetDTO>> get(UUID code, String lang) {
        BaseUtils.setSessionLang(lang);
        return new ResponseEntity<>(new Data<>(service.get(code,lang)), HttpStatus.OK);
    }

    @GetMapping("get_by_course/{code}")
    public ResponseEntity<Data<PriceGetDTO>> getByCourseCode(@PathVariable UUID code,
                                                             @RequestHeader("accept-language") String lang) {
        BaseUtils.setSessionLang(lang);
        return new ResponseEntity<>(new Data<>(service.getByCourseCode(code)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<PriceGetDTO>>> list(BaseCriteria criteria, String lang) {
        BaseUtils.setSessionLang(lang);
        return new ResponseEntity<>(new Data<>(service.list(criteria,lang)), HttpStatus.OK);
    }
}
