package uz.darkor.darkor_22.dto.course.price;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PriceGetDTO extends GenericDTO {
    private Double price;
    private List<String> offers;
}
