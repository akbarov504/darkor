package uz.darkor.darkor_22.dto.home.carousel;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.entity.system.Gallery;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CarouselGetDTO extends GenericDTO {
    private Gallery gallery;
    private String link;
}
