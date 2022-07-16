package uz.darkor.darkor_22.dto.home.carousel;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.entity.system.Gallery;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CarouselGetDTO extends GenericDTO {

    private Gallery gallery;

    private String link;

    @Builder
    public CarouselGetDTO(@NotNull(message = "code cannot be null") UUID code, Gallery gallery, String link) {
        super(code);
        this.gallery = gallery;
        this.link = link;
    }
}
