package uz.darkor.darkor_22.controller.homeService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.darkor.darkor_22.controller.AbstractController;
import uz.darkor.darkor_22.criteria.homeService.HomeServiceCriteria;
import uz.darkor.darkor_22.dto.home.home_service.HomeServiceCreateDTO;
import uz.darkor.darkor_22.dto.home.home_service.HomeServiceGetDTO;
import uz.darkor.darkor_22.dto.home.home_service.HomeServiceLocalizedDTO;
import uz.darkor.darkor_22.dto.home.home_service.HomeServiceUpdateDTO;
import uz.darkor.darkor_22.response.Data;
import uz.darkor.darkor_22.service.homeService.HomeSerServiceImpl;
import uz.darkor.darkor_22.utils.BaseUtils;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = BaseUtils.PATH+"/homeService/*")
public class HomeServiceControllerImpl extends AbstractController<HomeSerServiceImpl>{
    public HomeServiceControllerImpl(HomeSerServiceImpl service) {
        super(service);
    }


    @PostMapping("/add")
    public ResponseEntity<Data<HomeServiceLocalizedDTO>> create(@RequestBody HomeServiceCreateDTO DTO, @RequestHeader("accept-language") String lang) {
        return new ResponseEntity<>(new Data<>(service.create(DTO,lang)), HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<Data<HomeServiceLocalizedDTO>> update(@RequestBody HomeServiceUpdateDTO DTO,@RequestHeader("accept-language") String lang) {
        return new ResponseEntity<>(new Data<>(service.update(DTO,lang)),HttpStatus.OK);
    }


    @DeleteMapping("deleted/{id}")
    public ResponseEntity<Data<Boolean>> delete(@PathVariable Long id) {
        return new ResponseEntity<>(new Data<>(service.delete(id)),HttpStatus.OK);
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Data<HomeServiceLocalizedDTO>> get(@PathVariable Long id,@RequestHeader("accept-language") String lang) {
        return new ResponseEntity<>(new Data<>(service.get(id, lang)),HttpStatus.OK);
    }


    @GetMapping("/list")
    public ResponseEntity<Data<List<HomeServiceLocalizedDTO>>> list(@Valid HomeServiceCriteria criteria, @RequestHeader("accept-language") String lang) {
        return new ResponseEntity<>(new Data<>(service.list(criteria, lang)),HttpStatus.OK);
    }
}
