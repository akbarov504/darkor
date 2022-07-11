package uz.darkor.darkor_22.entity.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.darkor.darkor_22.dto.course.price.PriceGetDTO;
import uz.darkor.darkor_22.entity.Auditable;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Price extends Auditable {
    private Double price;
    @ElementCollection
    private List<String> offersUz;
    @ElementCollection
    private List<String> offersRu;
    @ElementCollection
    private List<String> offersEn;

    public PriceGetDTO getLocalizationDto(String lang) {
        if (lang.equals("uz")) {
            return PriceGetDTO.builder().price(this.price).offers(this.offersUz).build();
        } else if (lang.equals("ru")) {
            return PriceGetDTO.builder().price(this.price).offers(this.offersRu).build();
        }
        return PriceGetDTO.builder().price(this.price).offers(this.offersEn).build();
    }
}
