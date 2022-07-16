package uz.darkor.darkor_22.controller.statistics;

import uz.darkor.darkor_22.controller.GenericCUDController;
import uz.darkor.darkor_22.controller.GenericGLController;
import uz.darkor.darkor_22.criteria.statistics.StatisticsCriteria;
import uz.darkor.darkor_22.dto.home.statistics.StatisticsCreateDTO;
import uz.darkor.darkor_22.dto.home.statistics.StatisticsGetDTO;
import uz.darkor.darkor_22.dto.home.statistics.StatisticsUpdateDTO;

import java.util.UUID;

public interface StatisticsController extends GenericCUDController<StatisticsCreateDTO, StatisticsUpdateDTO,StatisticsGetDTO , UUID>, GenericGLController<StatisticsGetDTO, StatisticsCriteria,UUID> {
}
