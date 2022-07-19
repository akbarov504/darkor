package uz.darkor.darkor_22.controller.statistics;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.darkor.darkor_22.controller.AbstractController;
import uz.darkor.darkor_22.criteria.statistics.StatisticsCriteria;
import uz.darkor.darkor_22.dto.home.statistics.StatisticsCreateDTO;
import uz.darkor.darkor_22.dto.home.statistics.StatisticsGetDTO;
import uz.darkor.darkor_22.dto.home.statistics.StatisticsUpdateDTO;
import uz.darkor.darkor_22.response.Data;
import uz.darkor.darkor_22.service.statistics.StatisticsServiceImpl;
import uz.darkor.darkor_22.utils.BaseUtils;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = BaseUtils.PATH+"/statistics/*")
public class StatisticsControllerImpl extends AbstractController<StatisticsServiceImpl> implements StatisticsController {


    public StatisticsControllerImpl(StatisticsServiceImpl service) {
        super(service);
    }


    @Override
    public ResponseEntity<Data<StatisticsGetDTO>> create(StatisticsCreateDTO DTO,String lang) {
        return new ResponseEntity<>(new Data<>(service.create(DTO)),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<StatisticsGetDTO>> update(StatisticsUpdateDTO DTO,String lang) {
        return new ResponseEntity<>(new Data<>(service.update(DTO)),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(UUID code,String lang) {
        return new ResponseEntity<>(new Data<>(service.delete(code)),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<StatisticsGetDTO>> get(UUID code, String lang) {
        BaseUtils.setSessionLang(lang);
        return new ResponseEntity<>(new Data<>(service.get(code, lang)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<StatisticsGetDTO>>> list(StatisticsCriteria criteria, String lang) {
        BaseUtils.setSessionLang(lang);
        return new ResponseEntity<>(new Data<>(service.list(criteria, lang)),HttpStatus.OK);
    }
}
