package uz.darkor.darkor_22.controller.homeService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.darkor.darkor_22.controller.AbstractController;
import uz.darkor.darkor_22.criteria.homeService.HomeServiceCriteria;
import uz.darkor.darkor_22.dto.home.home_service.HomeServiceCreateDTO;
import uz.darkor.darkor_22.dto.home.home_service.HomeServiceGetDTO;
import uz.darkor.darkor_22.dto.home.home_service.HomeServiceUpdateDTO;
import uz.darkor.darkor_22.response.Data;
import uz.darkor.darkor_22.service.homeService.HomeSerServiceImpl;
import uz.darkor.darkor_22.utils.BaseUtils;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = BaseUtils.PATH+"/homeService/*")
public class HomeServiceControllerImpl extends AbstractController<HomeSerServiceImpl> implements HomeServiceController {
    public HomeServiceControllerImpl(HomeSerServiceImpl service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<HomeServiceGetDTO>> create(HomeServiceCreateDTO DTO,String lang) {
        return new ResponseEntity<>(new Data<>(service.create(DTO)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<HomeServiceGetDTO>> update(HomeServiceUpdateDTO DTO,String lang) {
        return new ResponseEntity<>(new Data<>(service.update(DTO)),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(UUID code,String lang) {
        return new ResponseEntity<>(new Data<>(service.delete(code)),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<HomeServiceGetDTO>> get(UUID code, String lang) {
        BaseUtils.setSessionLang(lang);
        return new ResponseEntity<>(new Data<>(service.get(code, lang)),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<HomeServiceGetDTO>>> list(HomeServiceCriteria criteria, String lang) {
        BaseUtils.setSessionLang(lang);
        return new ResponseEntity<>(new Data<>(service.list(criteria, lang)),HttpStatus.OK);
    }
}
