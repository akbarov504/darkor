package uz.darkor.darkor_22.entity.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import uz.darkor.darkor_22.dto.course.skill.SkillGetDTO;
import uz.darkor.darkor_22.entity.Auditable;
import uz.darkor.darkor_22.utils.BaseUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "is_deleted = false")
public class Skill extends Auditable {
    @Column(nullable = false, name = "name_uz")
    private String nameUz;

    @Column(nullable = false, name = "name_ru")
    private String nameRu;

    @Column(nullable = false, name = "name_en")
    private String nameEn;

    @Column(nullable = false, name = "description_uz")
    private String descriptionUz;

    @Column(nullable = false, name = "description_ru")
    private String descriptionRu;

    @Column(nullable = false, name = "description_en")
    private String descriptionEn;

    @ManyToOne(fetch = FetchType.EAGER)
    private Course course;
}
