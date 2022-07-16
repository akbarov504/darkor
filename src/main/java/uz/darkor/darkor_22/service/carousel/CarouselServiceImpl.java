package uz.darkor.darkor_22.service.carousel;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.darkor.darkor_22.criteria.carousel.CarouselCriteria;
import uz.darkor.darkor_22.criteria.course.CourseCriteria;
import uz.darkor.darkor_22.dto.course.course.CourseCreateDTO;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;
import uz.darkor.darkor_22.dto.course.course.CourseUpdateDTO;
import uz.darkor.darkor_22.dto.home.carousel.CarouselCreateDTO;
import uz.darkor.darkor_22.dto.home.carousel.CarouselGetDTO;
import uz.darkor.darkor_22.dto.home.carousel.CarouselUpdateDTO;
import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.entity.home.Carousel;
import uz.darkor.darkor_22.entity.home.HomeService;
import uz.darkor.darkor_22.exception.NotFoundException;
import uz.darkor.darkor_22.mapper.carousel.CarouselMapper;
import uz.darkor.darkor_22.mapper.course.CourseMapper;
import uz.darkor.darkor_22.repository.carousel.CarouselRepository;
import uz.darkor.darkor_22.repository.course.CourseRepository;
import uz.darkor.darkor_22.service.AbstractService;
import uz.darkor.darkor_22.service.BaseService;
import uz.darkor.darkor_22.utils.BaseUtils;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CarouselServiceImpl extends AbstractService<CarouselMapper, CarouselRepository> implements CarouselService {


    public CarouselServiceImpl(CarouselMapper mapper, CarouselRepository repository) {
        super(mapper, repository);
    }


    @Override
    public CarouselGetDTO create(CarouselCreateDTO DTO) {
        return repository.save(mapper.fromCreateDTO(DTO)).getLocalizationDto("uz");

    }

    @Override
    public CarouselGetDTO update(CarouselUpdateDTO DTO) {

        Carousel carousel = repository.findByCode(DTO.getCode())
                .orElseThrow(() -> new NotFoundException("Carousel topilmadi"));

        return repository.save(mapper.fromUpdateDTO(DTO,carousel)).getLocalizationDto("uz");

    }

    @Override
    public Boolean delete(UUID key) {
        try {
            repository.deleteByCode(key);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public CarouselGetDTO get(UUID key) {
        Carousel carousel = repository.findByCode(key)
                .orElseThrow(() -> new NotFoundException("Hech  nima topilmadi"));
        return carousel.getLocalizationDto(BaseUtils.getSessionLang());
    }

    @Override
    public List<CarouselGetDTO> list(CarouselCriteria criteria) {
        List<CarouselGetDTO> carouselGetDTOS = new ArrayList<>();
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        List<Carousel> courses = repository.findAll(request).stream().toList();
        for (Carousel c : courses) {
            carouselGetDTOS.add(c.getLocalizationDto(BaseUtils.getSessionLang()));
        }
        return carouselGetDTOS;
    }
}
