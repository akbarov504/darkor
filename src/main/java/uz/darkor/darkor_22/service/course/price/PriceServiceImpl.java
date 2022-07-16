package uz.darkor.darkor_22.service.course.price;

import org.springframework.stereotype.Service;
import uz.darkor.darkor_22.criteria.BaseCriteria;
import uz.darkor.darkor_22.dto.course.price.PriceCreateDTO;
import uz.darkor.darkor_22.dto.course.price.PriceGetDTO;
import uz.darkor.darkor_22.dto.course.price.PriceUpdateDTO;
import uz.darkor.darkor_22.entity.course.CourseDetail;
import uz.darkor.darkor_22.entity.course.Price;
import uz.darkor.darkor_22.exception.NotFoundException;
import uz.darkor.darkor_22.mapper.price.PriceMapper;
import uz.darkor.darkor_22.repository.course.detail.CourseDetailRepository;
import uz.darkor.darkor_22.repository.price.PriceRepository;
import uz.darkor.darkor_22.service.AbstractService;

import java.util.*;

@Service
public class PriceServiceImpl extends AbstractService<PriceMapper, PriceRepository> implements PriceService {

    private final CourseDetailRepository courseDetailRepository;

    public PriceServiceImpl(PriceMapper mapper,
                            PriceRepository repository,
                            CourseDetailRepository courseDetailRepository) {
        super(mapper, repository);
        this.courseDetailRepository = courseDetailRepository;
    }

    @Override
    public PriceGetDTO create(PriceCreateDTO DTO) {
        Price price = mapper.fromCreateDTO(DTO);
        Price newPrice = repository.save(price);
        return newPrice.getLocalizationDto();
    }

    @Override
    public PriceGetDTO update(PriceUpdateDTO DTO) {
        Price target = checkExistenceAndGetaByCode(DTO.getCode());
        Price updatedPrice = mapper.fromUpdateDTO(DTO, target);
        return updatedPrice.getLocalizationDto();
    }

    @Override
    public Boolean delete(UUID key) {
        return repository.deleteByCode(key);
    }

    @Override
    public PriceGetDTO get(UUID key) {
        Price price = checkExistenceAndGetaByCode(key);
        return price.getLocalizationDto();
    }

    @Override
    public PriceGetDTO getByCourseCode(UUID code) {
        CourseDetail courseDetail = courseDetailRepository
                .findByCode(code).orElseThrow(() -> new NotFoundException("COURSE_DETAIL_NOT_FOUND"));
        Price price = repository.findByCourseDetail(courseDetail)
                .orElse(new Price());
        return price.getLocalizationDto();
    }

    @Override
    public List<PriceGetDTO> list(BaseCriteria criteria) {
        List<Price> prices = repository.findAll();
        return getLocalizedPriceDTOList(prices);
    }

    private List<PriceGetDTO> getLocalizedPriceDTOList(List<Price> prices) {
        List<PriceGetDTO> priceGetDTOS = new ArrayList<>();
        for (Price price : prices)
            priceGetDTOS.add(price.getLocalizationDto());
        return priceGetDTOS;
    }

    private Price checkExistenceAndGetaByCode(UUID code) {
        return repository.findByCode(code)
                .orElseThrow(() -> new NotFoundException("PRICE_NOT_FOUND"));
    }
}
