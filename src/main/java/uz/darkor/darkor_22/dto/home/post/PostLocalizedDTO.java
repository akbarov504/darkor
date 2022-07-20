package uz.darkor.darkor_22.dto.home.post;

import lombok.*;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PostLocalizedDTO {

    private Long id;

    private FileDTO gallery;

    private  String title;

    private  String description;
}
