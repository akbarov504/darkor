package uz.darkor.darkor_22.dto.course.price;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PriceLocalizedDTO extends GenericDTO {
    private Long id;
    private Double price;
    private List<String> offers;

    @Builder
    public PriceLocalizedDTO(@NotNull(message = "code cannot be null") UUID code,
                             Long id,
                             Double price,
                             List<String> offers) {
        super(code);
        this.id = id;
        this.price = price;
        this.offers = offers;
    }
}
