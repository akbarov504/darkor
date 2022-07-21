package uz.darkor.darkor_22.service.faq;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.darkor.darkor_22.criteria.faq.FAQCriteria;
import uz.darkor.darkor_22.dto.system.faq.FAQCreateDTO;
import uz.darkor.darkor_22.dto.system.faq.FAQLocalizedDTO;
import uz.darkor.darkor_22.dto.system.faq.FAQUpdateDTO;
import uz.darkor.darkor_22.entity.system.FAQ;
import uz.darkor.darkor_22.exception.NotFoundException;
import uz.darkor.darkor_22.mapper.faq.FAQMapper;
import uz.darkor.darkor_22.repository.system.faq.FAQRepository;
import uz.darkor.darkor_22.service.AbstractService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class FAQServiceImpl extends AbstractService<FAQMapper, FAQRepository> implements FAQService {
    public FAQServiceImpl(FAQMapper mapper, FAQRepository repository) {
        super(mapper, repository);
    }

    @Override
    public FAQLocalizedDTO create(FAQCreateDTO DTO) {
        FAQ faq = mapper.fromCreateDTO(DTO);
        FAQ save = repository.save(faq);
        return mapper.toGetDTO(save).getLocalizationDto("uz");
    }

    @Override
    public FAQLocalizedDTO update(FAQUpdateDTO DTO) {
        FAQ faq = checkExistenceAndGetById(DTO.getCode());
        FAQ updateDTO = mapper.fromUpdateDTO(DTO, faq);
        FAQ save = repository.save(updateDTO);
        return mapper.toGetDTO(save).getLocalizationDto("uz");
    }

    @Override
    public Boolean delete(UUID key) {
        try {
            FAQ faq = repository.findByCode(key).orElseThrow(() -> {
                throw new NotFoundException("FAQ_NOT_FOUND");
            });
            faq.setDeleted(true);
            repository.save(faq);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public FAQLocalizedDTO get(UUID key, String language) {
        FAQ faq = checkExistenceAndGetById(key);
        return mapper.toGetDTO(faq).getLocalizationDto(language);
    }

    @Override
    public List<FAQLocalizedDTO> list(FAQCriteria criteria, String language) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        List<FAQ> content = repository.findAll(request).getContent();
        return getLocalizedDTOs(content, language);
    }

    private List<FAQLocalizedDTO> getLocalizedDTOs(List<FAQ> faqs, String lang) {
        List<FAQLocalizedDTO> faqLocalizedDTOS = new ArrayList<>();
        for (FAQ faq : faqs) {
            faqLocalizedDTOS.add(mapper.toGetDTO(faq).getLocalizationDto(lang));
        }
        return faqLocalizedDTOS;
    }

    private FAQ checkExistenceAndGetById(UUID code) {
        return repository.findByCode(code)
                .orElseThrow(() -> new NotFoundException("FAQ_NOT_FOUND"));
    }
}
