package uz.darkor.darkor_22.dto.home.home_service;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.entity.system.Gallery;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class HomeServiceGetDTO extends GenericDTO {
    private String title;
    private String description;
    private Gallery gallery;

    @Builder
    public HomeServiceGetDTO(@NotNull(message = "code cannot be null") UUID code, String title, String description, Gallery gallery) {
        super(code);
        this.title = title;
        this.description = description;
        this.gallery = gallery;
    }
}
