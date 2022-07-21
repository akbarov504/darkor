package uz.darkor.darkor_22.service.course.price;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.darkor.darkor_22.criteria.price.PriceCriteria;
import uz.darkor.darkor_22.dto.course.price.PriceCreateDTO;
import uz.darkor.darkor_22.dto.course.price.PriceLocalizedDTO;
import uz.darkor.darkor_22.dto.course.price.PriceUpdateDTO;
import uz.darkor.darkor_22.entity.course.Price;
import uz.darkor.darkor_22.exception.NotFoundException;
import uz.darkor.darkor_22.mapper.price.PriceMapper;
import uz.darkor.darkor_22.repository.price.PriceRepository;
import uz.darkor.darkor_22.service.AbstractService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PriceServiceImpl extends AbstractService<PriceMapper, PriceRepository> implements PriceService {

    public PriceServiceImpl(PriceMapper mapper, PriceRepository repository) {
        super(mapper, repository);
    }

    @Override
    public PriceLocalizedDTO create(PriceCreateDTO DTO) {
        Price price = mapper.fromCreateDTO(DTO);
        Price newPrice = repository.save(price);
        return mapper.toGetDTO(newPrice).getLocalizationDto("uz");
    }

    @Override
    public PriceLocalizedDTO update(PriceUpdateDTO DTO) {
        Price target = checkExistenceAndGetaByCode(DTO.getCode());
        Price updatedPrice = mapper.fromUpdateDTO(DTO, target);
        Price save = repository.save(updatedPrice);
        return mapper.toGetDTO(save).getLocalizationDto("uz");
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
    public PriceLocalizedDTO get(UUID key, String language) {
        Price price = checkExistenceAndGetaByCode(key);
        return mapper.toGetDTO(price).getLocalizationDto(language);
    }

    @Override
    public List<PriceLocalizedDTO> list(PriceCriteria criteria, String language) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        List<Price> prices = repository.findAll(request).getContent();
        return getLocalizedPriceDTOList(prices, language);
    }

    private List<PriceLocalizedDTO> getLocalizedPriceDTOList(List<Price> prices, String lang) {
        List<PriceLocalizedDTO> priceLocalizedDTOS = new ArrayList<>();
        for (Price price : prices)
            priceLocalizedDTOS.add(mapper.toGetDTO(price).getLocalizationDto(lang));
        return priceLocalizedDTOS;
    }

    private Price checkExistenceAndGetaByCode(UUID code) {
        return repository.findByCode(code).orElseThrow(() -> new NotFoundException("PRICE_NOT_FOUND"));
    }

    public Price createForEveryService(PriceCreateDTO DTO) {
        Price price = mapper.fromCreateDTO(DTO);
        return repository.save(price);
    }

}
