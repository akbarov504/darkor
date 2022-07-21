package uz.darkor.darkor_22.dto.system.faq;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;
import uz.darkor.darkor_22.dto.course.price.PriceLocalizedDTO;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FAQGetDTO extends GenericDTO {
    private Long id;

    private String questionUz;

    private String questionRu;

    private String questionEn;

    private String answerUz;

    private String answerRu;

    private String answerEn;

    private CourseGetDTO course;

    public FAQLocalizedDTO getLocalizationDto(String lang) {
        return switch (lang) {
            case "en" -> FAQLocalizedDTO.builder().code(this.getCode()).
                    id(this.id).
                    question(this.questionEn)
                    .answer(this.answerEn)
                    .course(this.course.getLocalizationDto("en"))
                    .build();
            case "ru" -> FAQLocalizedDTO.builder().code(this.getCode()).
                    id(this.id).
                    question(this.questionRu)
                    .answer(this.answerRu)
                    .course(this.course.getLocalizationDto("ru"))
                    .build();
            default -> FAQLocalizedDTO.builder().code(this.getCode()).
                    id(this.id).
                    question(this.questionUz)
                    .answer(this.answerUz)
                    .course(this.course.getLocalizationDto("uz"))
                    .build();
        };
    }
}
