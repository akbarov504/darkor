package uz.darkor.darkor_22.dto.home.home_service;

import lombok.*;
import uz.darkor.darkor_22.dto.BaseDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;


@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class HomeServiceLocalizedDTO implements BaseDTO {

    private Long id;
    private String title;
    private String description;
    private FileDTO gallery;
}
