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
    @Column(nullable = false)
    private String nameUZ;

    @Column(nullable = false)
    private String nameRu;

    @Column(nullable = false)
    private String nameEn;

    @Column(nullable = false)
    private String descriptionUz;

    @Column(nullable = false)
    private String descriptionRu;

    @Column(nullable = false)
    private String descriptionEn;

    @ManyToOne(fetch = FetchType.EAGER)
    private Course course;

    public SkillGetDTO getLocalizationDto() {
        String lang = BaseUtils.getSessionLang();
        if (Objects.isNull(lang)) lang = "en";
        return switch (lang) {
            case "en" -> SkillGetDTO.builder()
                    .code(this.getCode())
                    .name(this.nameEn)
                    .description(this.descriptionEn)
                    .course(this.course)
                    .build();
            case "ru" -> SkillGetDTO.builder()
                    .code(this.getCode())
                    .name(this.nameRu)
                    .description(this.descriptionRu)
                    .course(this.course)
                    .build();
            default -> SkillGetDTO.builder()
                    .code(this.getCode())
                    .name(this.nameUZ)
                    .description(this.descriptionUz)
                    .course(this.course)
                    .build();
        };
    }
}
