package uz.darkor.darkor_22.service.statistics;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.darkor.darkor_22.criteria.statistics.StatisticsCriteria;
import uz.darkor.darkor_22.dto.home.statistics.StatisticsCreateDTO;
import uz.darkor.darkor_22.dto.home.statistics.StatisticsGetDTO;
import uz.darkor.darkor_22.dto.home.statistics.StatisticsUpdateDTO;
import uz.darkor.darkor_22.entity.home.Statistics;
import uz.darkor.darkor_22.exception.NotFoundException;
import uz.darkor.darkor_22.mapper.statistics.StatisticsMapper;
import uz.darkor.darkor_22.repository.statistics.StatisticsRepository;
import uz.darkor.darkor_22.service.AbstractService;
import uz.darkor.darkor_22.utils.BaseUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StatisticsServiceImpl extends AbstractService<StatisticsMapper, StatisticsRepository> implements StatisticsService {


    public StatisticsServiceImpl(StatisticsMapper mapper, StatisticsRepository repository) {
        super(mapper, repository);
    }


    @Override
    public StatisticsGetDTO create(StatisticsCreateDTO DTO) {
        return repository.save(mapper.fromCreateDTO(DTO)).getLocalizationDto("uz");
    }

    @Override
    public StatisticsGetDTO update(StatisticsUpdateDTO DTO) {
        Statistics statistics = repository.findByCode(DTO.getCode())
                .orElseThrow(()-> new NotFoundException("owa gap"));

        return repository.save(mapper.fromUpdateDTO(DTO, statistics)).getLocalizationDto("uz");
    }

    @Override
    public Boolean delete(UUID key) {
        try {
            repository.deleteByCode(key);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public StatisticsGetDTO get(UUID key) {
        Statistics statistics = repository.findByCode(key)
                .orElseThrow(() -> new NotFoundException("Statistika topilmadi"));
        StatisticsGetDTO Dto = statistics.getLocalizationDto(BaseUtils.getSessionLang());
        return Dto;
    }

    @Override
    public List<StatisticsGetDTO> list(StatisticsCriteria criteria) {
        List<StatisticsGetDTO> statisticsGetDTOS = new ArrayList<>();
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        List<Statistics> courses = repository.findAll(request).stream().toList();
        for (Statistics c : courses) {
            statisticsGetDTOS.add(c.getLocalizationDto(BaseUtils.getSessionLang()));
        }
        return statisticsGetDTOS;
    }
}
