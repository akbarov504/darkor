package uz.darkor.darkor_22.dto.system.faq;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.entity.course.Course;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FAQGetDTO extends GenericDTO {
    private String question;
    private String answer;
    private Course course;
}
