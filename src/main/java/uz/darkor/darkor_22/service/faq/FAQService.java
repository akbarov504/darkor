package uz.darkor.darkor_22.service.faq;

import uz.darkor.darkor_22.criteria.faq.FAQCriteria;
import uz.darkor.darkor_22.dto.system.faq.FAQCreateDTO;
import uz.darkor.darkor_22.dto.system.faq.FAQGetDTO;
import uz.darkor.darkor_22.dto.system.faq.FAQLocalizedDTO;
import uz.darkor.darkor_22.dto.system.faq.FAQUpdateDTO;
import uz.darkor.darkor_22.service.GenericCUDService;
import uz.darkor.darkor_22.service.GenericGLService;

import java.util.UUID;

public interface FAQService extends GenericCUDService<FAQCreateDTO, FAQUpdateDTO, FAQLocalizedDTO, UUID>, GenericGLService<FAQLocalizedDTO, FAQCriteria, UUID> {
}
