package uz.darkor.darkor_22.entity.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import uz.darkor.darkor_22.dto.course.price.PriceGetDTO;
import uz.darkor.darkor_22.entity.Auditable;
import uz.darkor.darkor_22.utils.BaseUtils;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "is_deleted = false")
public class Price extends Auditable {
    private Double price;
    @ElementCollection
    private List<String> offersUz;
    @ElementCollection
    private List<String> offersRu;
    @ElementCollection
    private List<String> offersEn;

    @OneToOne(mappedBy = "price")
    private CourseDetail courseDetail;

    public PriceGetDTO getLocalizationDto() {
        String lang = BaseUtils.getSessionLang();
        return switch (lang) {
            case "en" -> PriceGetDTO.builder().code(this.getCode()).
                    price(this.price)
                    .offers(this.offersEn)
                    .build();
            case "ru" -> PriceGetDTO.builder().code(this.getCode()).
                    price(this.price)
                    .offers(this.offersRu)
                    .build();
            default -> PriceGetDTO.builder().code(this.getCode()).
                    price(this.price)
                    .offers(this.offersUz)
                    .build();
        };
    }
}
