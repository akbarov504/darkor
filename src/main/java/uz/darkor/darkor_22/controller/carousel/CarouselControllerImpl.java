package uz.darkor.darkor_22.controller.carousel;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.darkor.darkor_22.controller.AbstractController;
import uz.darkor.darkor_22.criteria.carousel.CarouselCriteria;
import uz.darkor.darkor_22.dto.home.carousel.CarouselCreateDTO;
import uz.darkor.darkor_22.dto.home.carousel.CarouselGetDTO;
import uz.darkor.darkor_22.dto.home.carousel.CarouselUpdateDTO;
import uz.darkor.darkor_22.response.Data;
import uz.darkor.darkor_22.service.carousel.CarouselServiceImpl;
import uz.darkor.darkor_22.utils.BaseUtils;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = BaseUtils.PATH+"/carousel/*")
public class CarouselControllerImpl extends AbstractController<CarouselServiceImpl> implements CarouselController{

    public CarouselControllerImpl(CarouselServiceImpl service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<CarouselGetDTO>> create(CarouselCreateDTO DTO,String lang) {

        BaseUtils.setSessionLang(lang);
        return new ResponseEntity<>(new Data<>(service.create(DTO)), HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<Data<CarouselGetDTO>> update(CarouselUpdateDTO DTO,String lang) {
        BaseUtils.setSessionLang(lang);
        return new ResponseEntity<>(new Data<>(service.update(DTO)),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(UUID code,String lang) {
        BaseUtils.setSessionLang(lang);
        return new ResponseEntity<>(new Data<>(service.delete(code)),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CarouselGetDTO>> get(UUID code, String lang) {
        BaseUtils.setSessionLang(lang);
        return new ResponseEntity<>(new Data<>(service.get(code,lang)),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<CarouselGetDTO>>> list(CarouselCriteria criteria, String lang) {
        BaseUtils.setSessionLang(lang);
        return new ResponseEntity<>(new Data<>(service.list(criteria,lang)),HttpStatus.OK);
    }


}
