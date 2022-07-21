package uz.darkor.darkor_22.dto.system.faq;

import lombok.*;
import uz.darkor.darkor_22.dto.BaseDTO;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FAQCreateDTO implements BaseDTO {
    @NotBlank(message = "question uz cannot be null")
    private String questionUz;

    @NotBlank(message = "question ru cannot be null")
    private String questionRu;

    @NotBlank(message = "question en cannot be null")
    private String questionEn;

    @NotBlank(message = "answer uz cannot be null")
    private String answerUz;

    @NotBlank(message = "answer ru cannot be null")
    private String answerRu;

    @NotBlank(message = "answer en cannot be null")
    private String answerEn;

    @NotBlank(message = "course cannot be null")
    private CourseGetDTO course;
}
