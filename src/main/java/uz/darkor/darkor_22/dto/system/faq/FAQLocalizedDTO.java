package uz.darkor.darkor_22.dto.system.faq;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.dto.course.course.CourseLocalizationDTO;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FAQLocalizedDTO extends GenericDTO {
    private Long id;

    private String question;

    private String answer;

    private CourseLocalizationDTO course;

    @Builder
    public FAQLocalizedDTO(@NotNull(message = "code cannot be null") UUID code,
                           Long id,
                           String question,
                           String answer, CourseLocalizationDTO course) {
        super(code);
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.course = course;
    }
}
