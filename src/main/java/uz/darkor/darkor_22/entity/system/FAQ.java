package uz.darkor.darkor_22.entity.system;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.darkor.darkor_22.dto.system.faq.FAQGetDTO;
import uz.darkor.darkor_22.entity.Auditable;
import uz.darkor.darkor_22.entity.course.Course;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FAQ extends Auditable {
    @Column(nullable = false)
    private String questionUZ;

    @Column(nullable = false)
    private String questionRu;

    @Column(nullable = false)
    private String questionEn;

    @Column(nullable = false)
    private String answerUZ;

    @Column(nullable = false)
    private String answerRu;

    @Column(nullable = false)
    private String answerEn;

    @ManyToOne
    private Course course;


    public FAQGetDTO getLocalizationDto(String lang) {
        if (lang.equals("uz")) {
            return FAQGetDTO.builder().question(this.questionUZ).answer(this.answerUZ).course(this.course).build();
        } else if (lang.equals("ru")) {
            return FAQGetDTO.builder().question(this.questionRu).answer(this.answerRu).course(this.course).build();
        }
        return FAQGetDTO.builder().question(this.questionEn).answer(this.answerEn).course(this.course).build();
    }
}
