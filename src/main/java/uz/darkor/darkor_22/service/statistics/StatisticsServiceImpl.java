package uz.darkor.darkor_22.service.statistics;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.darkor.darkor_22.criteria.statistics.StatisticsCriteria;
import uz.darkor.darkor_22.dto.home.statistics.StatisticsCreateDTO;
import uz.darkor.darkor_22.dto.home.statistics.StatisticsGetDTO;
import uz.darkor.darkor_22.dto.home.statistics.StatisticsLocalizedDTO;
import uz.darkor.darkor_22.dto.home.statistics.StatisticsUpdateDTO;
import uz.darkor.darkor_22.entity.home.Statistics;
import uz.darkor.darkor_22.enums.StatisticsType;
import uz.darkor.darkor_22.exception.NotFoundException;
import uz.darkor.darkor_22.mapper.statistics.StatisticsMapper;
import uz.darkor.darkor_22.repository.statistics.StatisticsRepository;
import uz.darkor.darkor_22.service.AbstractService;
import uz.darkor.darkor_22.utils.BaseUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StatisticsServiceImpl extends AbstractService<StatisticsMapper, StatisticsRepository> {


    public StatisticsServiceImpl(StatisticsMapper mapper, StatisticsRepository repository) {
        super(mapper, repository);
    }



    public StatisticsLocalizedDTO create(StatisticsCreateDTO createDTO,String lang) {

        Statistics statistics  = new Statistics();
        statistics.setNumber( createDTO.getNumber() );

        if (createDTO.getStatisticsType() != null)
            statistics.setStatisticsType(Enum.valueOf(StatisticsType.class,createDTO.getStatisticsType()));

        statistics.setTitleUz( createDTO.getTitleUz() );
        statistics.setTitleRu( createDTO.getTitleRu() );
        statistics.setTitleEn( createDTO.getTitleEn() );
        statistics.setDescriptionUz( createDTO.getDescriptionUz() );
        statistics.setDescriptionRu( createDTO.getDescriptionRu() );
        statistics.setDescriptionEn( createDTO.getDescriptionEn() );
        repository.save(statistics);
        return mapper.toGetDTO(statistics).getLocalizationDto(lang);
    }


    public StatisticsLocalizedDTO update(StatisticsUpdateDTO updateDTO,String lang) {
        Statistics statistics = repository.findById(updateDTO.getId())
                .orElseThrow(()-> new NotFoundException("Not Found"));
        statistics.setNumber( updateDTO.getNumber());

        if (updateDTO.getStatisticsType() != null)
            statistics.setStatisticsType(Enum.valueOf(StatisticsType.class,updateDTO.getStatisticsType()));

        statistics.setTitleUz( updateDTO.getTitleUz() );
        statistics.setTitleRu( updateDTO.getTitleRu() );
        statistics.setTitleEn( updateDTO.getTitleEn() );
        statistics.setDescriptionUz( updateDTO.getDescriptionUz() );
        statistics.setDescriptionRu( updateDTO.getDescriptionRu() );
        statistics.setDescriptionEn( updateDTO.getDescriptionEn() );
        repository.save(statistics);
        return mapper.toGetDTO(statistics).getLocalizationDto(lang);
    }


    public Boolean delete(Long id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public StatisticsLocalizedDTO get(Long id, String language) {

        Statistics statistics = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not Found"));

        return mapper.toGetDTO(statistics).getLocalizationDto(language);
    }


    public List<StatisticsLocalizedDTO> list(StatisticsCriteria criteria, String language) {
        List<StatisticsLocalizedDTO> statisticsGetDTOS = new ArrayList<>();
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        List<Statistics> courses = repository.findAll(request).stream().toList();
        for (Statistics c : courses) {
            statisticsGetDTOS.add(mapper.toGetDTO(c).getLocalizationDto(language));
        }
        return statisticsGetDTOS;
    }
}
