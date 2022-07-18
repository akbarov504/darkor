package uz.darkor.darkor_22.dto.home.carousel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.darkor.darkor_22.criteria.BaseCriteria;
import uz.darkor.darkor_22.dto.BaseDTO;

import uz.darkor.darkor_22.dto.system.gallery.FileDTO;
import uz.darkor.darkor_22.entity.system.Gallery;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarouselCreateDTO implements BaseDTO{

    @NotNull(message = "link not be null")
    private FileDTO galleryUz;

    @NotNull(message = "link not be null")
    private FileDTO  galleryRu;

    @NotNull(message = "link not be null")
    private FileDTO galleryEn;

    @NotNull(message = "link not be null")
    @Size(min = 3,max = 250)
    private String linkUz;

    @NotNull(message = "link not be null")
    @Size(min = 3,max = 250)
    private String linkRu;

    @NotNull(message = "link not be null")
    @Size(min = 3,max = 250)
    private String linkEn;
}
