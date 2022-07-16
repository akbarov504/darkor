package uz.darkor.darkor_22.mapper.statistics;

import org.mapstruct.Mapper;
import uz.darkor.darkor_22.dto.home.statistics.StatisticsCreateDTO;
import uz.darkor.darkor_22.dto.home.statistics.StatisticsGetDTO;
import uz.darkor.darkor_22.dto.home.statistics.StatisticsUpdateDTO;
import uz.darkor.darkor_22.entity.home.Statistics;
import uz.darkor.darkor_22.mapper.GenericMapper;
import uz.darkor.darkor_22.mapper.gallery.GalleryMapper;
import uz.darkor.darkor_22.mapper.system.file.FileMapper;

@Mapper(componentModel = "spring", uses = {FileMapper.class})
public interface StatisticsMapper extends GenericMapper<StatisticsCreateDTO, StatisticsUpdateDTO, StatisticsGetDTO, Statistics> {
}
