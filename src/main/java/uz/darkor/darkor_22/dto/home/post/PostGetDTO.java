package uz.darkor.darkor_22.dto.home.post;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.entity.system.Gallery;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PostGetDTO extends GenericDTO {
    private String title;
    private String description;
    private Gallery gallery;
}
