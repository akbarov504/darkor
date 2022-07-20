package uz.darkor.darkor_22.service.course.price;

import org.springframework.stereotype.Service;
import uz.darkor.darkor_22.criteria.price.PriceCriteria;
import uz.darkor.darkor_22.dto.course.price.PriceCreateDTO;
import uz.darkor.darkor_22.dto.course.price.PriceGetDTO;
import uz.darkor.darkor_22.dto.course.price.PriceUpdateDTO;
import uz.darkor.darkor_22.entity.course.Price;
import uz.darkor.darkor_22.exception.NotFoundException;
import uz.darkor.darkor_22.mapper.price.PriceMapper;
import uz.darkor.darkor_22.repository.price.PriceRepository;
import uz.darkor.darkor_22.service.AbstractService;
import uz.darkor.darkor_22.utils.BaseUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PriceServiceImpl extends AbstractService<PriceMapper, PriceRepository> implements PriceService {

    public PriceServiceImpl(PriceMapper mapper, PriceRepository repository) {
        super(mapper, repository);
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
        repository.save(updatedPrice);
        return updatedPrice.getLocalizationDto();
    }

    @Override
    public Boolean delete(UUID key) {
        try {
            Price price = repository.findByCode(key).orElseThrow(() -> {
                throw new NotFoundException("Price not found !");
            });
            price.setDeleted(true);
            repository.save(price);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public PriceGetDTO get(UUID key, String language) {
        BaseUtils.setSessionLang(language);
        Price price = checkExistenceAndGetaByCode(key);
        return price.getLocalizationDto();
    }

    @Override
    public List<PriceGetDTO> list(PriceCriteria criteria, String language) {
        BaseUtils.setSessionLang(language);
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
        return repository.findByCode(code).orElseThrow(() -> new NotFoundException("PRICE_NOT_FOUND"));
    }

    public Price createForEveryService(PriceCreateDTO DTO) {
        Price price = mapper.fromCreateDTO(DTO);
        return repository.save(price);
    }

}
