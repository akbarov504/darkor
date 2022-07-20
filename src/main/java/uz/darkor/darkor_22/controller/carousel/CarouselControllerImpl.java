package uz.darkor.darkor_22.controller.carousel;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.darkor.darkor_22.controller.AbstractController;
import uz.darkor.darkor_22.criteria.carousel.CarouselCriteria;
import uz.darkor.darkor_22.dto.home.carousel.CarouselCreateDTO;
import uz.darkor.darkor_22.dto.home.carousel.CarouselGetDTO;
import uz.darkor.darkor_22.dto.home.carousel.CarouselLocalizedDTO;
import uz.darkor.darkor_22.dto.home.carousel.CarouselUpdateDTO;
import uz.darkor.darkor_22.response.Data;
import uz.darkor.darkor_22.service.carousel.CarouselServiceImpl;
import uz.darkor.darkor_22.utils.BaseUtils;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = BaseUtils.PATH+"/carousel/*")
public class CarouselControllerImpl extends AbstractController<CarouselServiceImpl>{

    public CarouselControllerImpl(CarouselServiceImpl service) {
        super(service);
    }

    @PostMapping("/addCarousel")
    public ResponseEntity<Data<CarouselLocalizedDTO>> create(@RequestBody CarouselCreateDTO DTO,@RequestHeader("accept-language") String lang) {
        return new ResponseEntity<>(new Data<>(service.create(DTO,lang)), HttpStatus.CREATED);

    }



    @PutMapping("/updateCarousel")
    public ResponseEntity<Data<CarouselLocalizedDTO>> update(@RequestBody CarouselUpdateDTO DTO,@RequestHeader("accept-language") String lang) {
        return new ResponseEntity<>(new Data<>(service.update(DTO,lang)),HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Data<Boolean>> delete(@PathVariable @Valid Long id) {
        return new ResponseEntity<>(new Data<>(service.delete(id)),HttpStatus.OK);
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Data<CarouselLocalizedDTO>> getCarousel(@PathVariable Long  id, @RequestHeader("accept-language") String lang) {
        return new ResponseEntity<>(new Data<>(service.getCarousel(id,lang)),HttpStatus.OK);
    }


    @GetMapping("/list")
    public ResponseEntity<Data<List<CarouselLocalizedDTO>>> listMy(@Valid CarouselCriteria criteria, @RequestHeader("accept-language") String lang) {
        return new ResponseEntity<>(new Data<>(service.listMy(criteria,lang)),HttpStatus.OK);
    }


}
