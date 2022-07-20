package uz.darkor.darkor_22.dto.home.carousel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;
import uz.darkor.darkor_22.dto.system.gallery.GalleryUpdateDTO;
import uz.darkor.darkor_22.entity.system.Gallery;

import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CarouselUpdateDTO extends GenericDTO {

    @NotNull(message = "id cannot be null")
    private Long id;
    
    @NotNull(message = "gallery bosh bolishi mumkin emas")
    private FileDTO galleryUz;

    @NotNull(message = "галерея не может быть головой")
    private FileDTO galleryRu;

    @NotNull(message = "gallery not be null ")
    private FileDTO galleryEn;

    @NotNull(message = "link bosh bolishi mumkin emas")
    @Size(min = 3,max = 200)
    private String linkUz;

    @NotNull(message = "link bosh bolishi mumkin emas")
    @Size(min = 3,max = 200)
    private String linkRu;

    @NotNull(message = "link bosh bolishi mumkin emas")
    @Size(min = 3,max = 200)
    private String linkEn;

}
