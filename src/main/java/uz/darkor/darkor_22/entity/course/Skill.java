package uz.darkor.darkor_22.entity.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.darkor.darkor_22.dto.course.skill.SkillGetDTO;
import uz.darkor.darkor_22.entity.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;

    public SkillGetDTO getLocalizationDto(String lang) {
        if (lang.equals("uz")) {
            return SkillGetDTO.builder().name(this.nameUZ).description(this.descriptionUz).course(this.course).build();
        } else if (lang.equals("ru")) {
            return SkillGetDTO.builder().name(this.nameRu).description(this.descriptionRu).course(this.course).build();
        }
        return SkillGetDTO.builder().name(this.nameEn).description(this.descriptionEn).course(this.course).build();
    }
}
