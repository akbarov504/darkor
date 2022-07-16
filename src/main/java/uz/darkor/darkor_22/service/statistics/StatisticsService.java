package uz.darkor.darkor_22.service.statistics;

import uz.darkor.darkor_22.criteria.statistics.StatisticsCriteria;
import uz.darkor.darkor_22.dto.home.statistics.StatisticsCreateDTO;
import uz.darkor.darkor_22.dto.home.statistics.StatisticsGetDTO;
import uz.darkor.darkor_22.dto.home.statistics.StatisticsUpdateDTO;
import uz.darkor.darkor_22.service.GenericCUDService;
import uz.darkor.darkor_22.service.GenericGLService;

import java.util.UUID;

public interface StatisticsService extends GenericCUDService<StatisticsCreateDTO, StatisticsUpdateDTO, StatisticsGetDTO, UUID> , GenericGLService<StatisticsGetDTO, StatisticsCriteria,UUID> {
}
