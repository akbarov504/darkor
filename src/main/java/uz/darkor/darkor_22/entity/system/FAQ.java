package uz.darkor.darkor_22.entity.system;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
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
@Where(clause = "is_deleted = false")
public class FAQ extends Auditable {
    @Column(nullable = false)
    private String questionUz;

    @Column(nullable = false)
    private String questionRu;

    @Column(nullable = false)
    private String questionEn;

    @Column(nullable = false)
    private String answerUz;

    @Column(nullable = false)
    private String answerRu;

    @Column(nullable = false)
    private String answerEn;

    @ManyToOne
    private Course course;
}
