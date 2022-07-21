package uz.darkor.darkor_22.controller.faq;

import uz.darkor.darkor_22.controller.GenericCUDController;
import uz.darkor.darkor_22.controller.GenericGLController;
import uz.darkor.darkor_22.criteria.faq.FAQCriteria;
import uz.darkor.darkor_22.dto.system.faq.FAQCreateDTO;
import uz.darkor.darkor_22.dto.system.faq.FAQGetDTO;
import uz.darkor.darkor_22.dto.system.faq.FAQLocalizedDTO;
import uz.darkor.darkor_22.dto.system.faq.FAQUpdateDTO;

import java.util.UUID;

public interface FAQController extends GenericCUDController<FAQCreateDTO, FAQUpdateDTO, FAQLocalizedDTO, UUID>, GenericGLController<FAQLocalizedDTO, FAQCriteria, UUID> {
}
