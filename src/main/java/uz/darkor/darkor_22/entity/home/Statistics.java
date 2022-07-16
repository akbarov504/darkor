package uz.darkor.darkor_22.entity.home;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import uz.darkor.darkor_22.dto.home.statistics.StatisticsGetDTO;
import uz.darkor.darkor_22.entity.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Getter
@Setter
@Table(indexes = @Index(name = "statistics_index", columnList = "code", unique = true))
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Where(clause = "is_deleted=false")
public class Statistics extends Auditable {
    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private String titleUz;

    @Column(nullable = false)
    private String titleRu;

    @Column(nullable = false)
    private String titleEn;

    @Column(nullable = false)
    private String descriptionUz;

    @Column(nullable = false)
    private String descriptionRu;

    @Column(nullable = false)
    private String descriptionEn;

    public StatisticsGetDTO getLocalizationDto(String lang) {

        if (lang.equals("uz")) {
            return StatisticsGetDTO.builder().code(this.getCode()).title(this.titleUz).description(this.descriptionUz).number(this.number).build();
        } else if (lang.equals("ru")) {
            return StatisticsGetDTO.builder().code(this.getCode()).title(this.titleUz).description(this.descriptionUz).number(this.number).build();
        }
        return StatisticsGetDTO.builder().code(this.getCode()).title(this.titleUz).description(this.descriptionUz).number(this.number).build();
    }
}
