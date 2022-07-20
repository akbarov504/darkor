package uz.darkor.darkor_22.dto.course.price;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import uz.darkor.darkor_22.dto.GenericDTO;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PriceGetDTO extends GenericDTO {
    private Long id;
    private Double price;

    private List<String> offersUz;

    private List<String> offersRu;

    private List<String> offersEn;

    public PriceLocalizedDTO getLocalizationDto(String lang) {
        return switch (lang) {
            case "en" -> PriceLocalizedDTO.builder().code(this.getCode()).
                    id(this.id).
                    price(this.price)
                    .offers(this.offersEn)
                    .build();
            case "ru" -> PriceLocalizedDTO.builder().code(this.getCode()).
                    id(this.id).
                    price(this.price)
                    .offers(this.offersRu)
                    .build();
            default -> PriceLocalizedDTO.builder().code(this.getCode()).
                    id(this.id).
                    price(this.price)
                    .offers(this.offersUz)
                    .build();
        };
    }
}
