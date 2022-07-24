package uz.darkor.darkor_22.controller.course.graduated;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.darkor.darkor_22.controller.AbstractController;
import uz.darkor.darkor_22.criteria.BaseCriteria;
import uz.darkor.darkor_22.criteria.graduated.GraduatedCriteria;
import uz.darkor.darkor_22.dto.course.graduated.GraduatedCreateDTO;
import uz.darkor.darkor_22.dto.course.graduated.GraduatedLocalizedDTO;
import uz.darkor.darkor_22.dto.course.graduated.GraduatedUpdateDTO;
import uz.darkor.darkor_22.response.Data;
import uz.darkor.darkor_22.service.course.graduated.GraduatedService;
import uz.darkor.darkor_22.utils.BaseUtils;

import java.util.List;
import java.util.UUID;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(BaseUtils.PATH + "/graduated/*")
public class GraduatedControllerImpl extends AbstractController<GraduatedService> implements GraduatedController {

    public GraduatedControllerImpl(GraduatedService service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<GraduatedLocalizedDTO>> create(GraduatedCreateDTO DTO,String lang) {
        BaseUtils.setSessionLang(lang);
        return new ResponseEntity<>(new Data<>(service.create(DTO)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<GraduatedLocalizedDTO>> update(GraduatedUpdateDTO DTO,String lang) {
        BaseUtils.setSessionLang(lang);
        return new ResponseEntity<>(new Data<>(service.update(DTO)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(UUID code,String lang) {
        BaseUtils.setSessionLang(lang);
        return new ResponseEntity<>(new Data<>(service.delete(code)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<GraduatedLocalizedDTO>> get(UUID code, String lang) {
        BaseUtils.setSessionLang(lang);
        return new ResponseEntity<>(new Data<>(service.get(code,lang)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<GraduatedLocalizedDTO>>> list(GraduatedCriteria criteria, String lang) {
        BaseUtils.setSessionLang(lang);
        return new ResponseEntity<>(new Data<>(service.list(criteria,lang)), HttpStatus.OK);
    }

    @GetMapping("get_by_courese/{code}")
    public ResponseEntity<Data<List<GraduatedLocalizedDTO>>> getByCourse(@PathVariable UUID code) {
        return new ResponseEntity<>(new Data<>(service.getByCourseCode(code)), HttpStatus.OK);
    }

}
