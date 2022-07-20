package uz.darkor.darkor_22.dto.home.carousel;


import lombok.*;
import uz.darkor.darkor_22.dto.BaseDTO;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CarouselLocalizedDTO implements BaseDTO {

    private Long id;

    private FileDTO gallery;

    private String link;

}
