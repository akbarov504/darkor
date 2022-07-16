package uz.darkor.darkor_22.service.homeService;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.darkor.darkor_22.criteria.homeService.HomeServiceCriteria;
import uz.darkor.darkor_22.dto.home.home_service.HomeServiceCreateDTO;
import uz.darkor.darkor_22.dto.home.home_service.HomeServiceGetDTO;
import uz.darkor.darkor_22.dto.home.home_service.HomeServiceUpdateDTO;
import uz.darkor.darkor_22.dto.home.statistics.StatisticsGetDTO;
import uz.darkor.darkor_22.entity.home.HomeService;
import uz.darkor.darkor_22.entity.home.Statistics;
import uz.darkor.darkor_22.exception.NotFoundException;
import uz.darkor.darkor_22.mapper.homeService.HomeServiceMapper;
import uz.darkor.darkor_22.repository.homeService.HomeServiceRepository;
import uz.darkor.darkor_22.service.AbstractService;
import uz.darkor.darkor_22.utils.BaseUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class HomeSerServiceImpl extends AbstractService<HomeServiceMapper, HomeServiceRepository> implements HomeSerService {


    public HomeSerServiceImpl(HomeServiceMapper mapper, HomeServiceRepository repository) {
        super(mapper, repository);
    }

    @Override
    public HomeServiceGetDTO create(HomeServiceCreateDTO DTO) {
        return repository.save(mapper.fromCreateDTO(DTO)).getLocalizationDto("uz");
    }

    @Override
    public HomeServiceGetDTO update(HomeServiceUpdateDTO DTO) {
        HomeService homeService = repository.findByCode(DTO.getCode())
                .orElseThrow(() -> new NotFoundException("Hech  nima topilmadi"));

        return repository.save(mapper.fromUpdateDTO(DTO,homeService)).getLocalizationDto("uz");
    }

    @Override
    public Boolean delete(UUID key) {

        try{
            repository.deleteByCode(key);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public HomeServiceGetDTO get(UUID key, String language) {
        HomeService homeService = repository.findByCode(key)
                .orElseThrow(() -> new NotFoundException("Hech  nima topilmadi"));
        return homeService.getLocalizationDto(BaseUtils.getSessionLang());
    }

    @Override
    public List<HomeServiceGetDTO> list(HomeServiceCriteria criteria, String language) {

        List<HomeServiceGetDTO> homeServiceGetDTOS = new ArrayList<>();
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        List<HomeService> homeServices = repository.findAll(request).stream().toList();
        for (HomeService c : homeServices) {
            homeServiceGetDTOS.add(c.getLocalizationDto(BaseUtils.getSessionLang()));
        }
        return homeServiceGetDTOS;

    }

}
