package uz.darkor.darkor_22.controller.statistics;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.darkor.darkor_22.controller.AbstractController;
import uz.darkor.darkor_22.criteria.statistics.StatisticsCriteria;
import uz.darkor.darkor_22.dto.home.statistics.StatisticsCreateDTO;
import uz.darkor.darkor_22.dto.home.statistics.StatisticsGetDTO;
import uz.darkor.darkor_22.dto.home.statistics.StatisticsLocalizedDTO;
import uz.darkor.darkor_22.dto.home.statistics.StatisticsUpdateDTO;
import uz.darkor.darkor_22.response.Data;
import uz.darkor.darkor_22.service.statistics.StatisticsServiceImpl;
import uz.darkor.darkor_22.utils.BaseUtils;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(value = BaseUtils.PATH+"/statistics/*")
public class StatisticsControllerImpl extends AbstractController<StatisticsServiceImpl>{


    public StatisticsControllerImpl(StatisticsServiceImpl service) {
        super(service);
    }


    @PostMapping("/add")
    public ResponseEntity<Data<StatisticsLocalizedDTO>> create(StatisticsCreateDTO DTO, @RequestHeader("accept-language") String lang) {
        return new ResponseEntity<>(new Data<>(service.create(DTO,lang)),HttpStatus.OK);
    }

   @PutMapping("/updated")
    public ResponseEntity<Data<StatisticsLocalizedDTO>> update(StatisticsUpdateDTO DTO, @RequestHeader("accept-language") String lang) {
        return new ResponseEntity<>(new Data<>(service.update(DTO,lang)),HttpStatus.OK);
    }

    @DeleteMapping("/deleted/{id}")
    public ResponseEntity<Data<Boolean>> delete(@PathVariable  Long id) {
        return new ResponseEntity<>(new Data<>(service.delete(id)),HttpStatus.OK);
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Data<StatisticsLocalizedDTO>> get(@PathVariable Long id, @RequestHeader("accept-language") String lang) {

        return new ResponseEntity<>(new Data<>(service.get(id, lang)), HttpStatus.OK);
    }

  @GetMapping("/list")
    public ResponseEntity<Data<List<StatisticsLocalizedDTO>>> list(@Valid  StatisticsCriteria criteria, @RequestHeader("accept-language") String lang) {
        return new ResponseEntity<>(new Data<>(service.list(criteria, lang)),HttpStatus.OK);
    }
}
