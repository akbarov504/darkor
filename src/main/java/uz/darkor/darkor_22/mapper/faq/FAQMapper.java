package uz.darkor.darkor_22.mapper.faq;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.darkor.darkor_22.dto.system.faq.FAQCreateDTO;
import uz.darkor.darkor_22.dto.system.faq.FAQGetDTO;
import uz.darkor.darkor_22.dto.system.faq.FAQUpdateDTO;
import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.entity.system.FAQ;
import uz.darkor.darkor_22.mapper.GenericMapper;

@Component
@Mapper(componentModel = "spring")
public interface FAQMapper extends GenericMapper<FAQCreateDTO, FAQUpdateDTO, FAQGetDTO, FAQ> {
}
