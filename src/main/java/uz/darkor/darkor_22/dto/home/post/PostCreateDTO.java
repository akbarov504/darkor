package uz.darkor.darkor_22.dto.home.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.darkor.darkor_22.dto.BaseDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostCreateDTO implements BaseDTO {

    @NotNull(message = "GalleryUz not be null")
    private FileDTO galleryUz;

    @NotNull(message = "GalleryRu not be null")
    private FileDTO galleryRu;

    @NotNull(message = "GalleryEn not be null")
    private FileDTO galleryEn;

    @NotNull(message = "titleUz not be null")
    @Size(min = 3,max =250 )
    private String titleUz;

    @NotNull(message = "titleRu not be null")
    @Size(min = 3,max =250 )
    private String titleRU;

    @NotNull(message = "titleEn not be null")
    @Size(min = 3,max =250 )
    private String titleEn;


    @NotNull(message = "descriptionUz not be null")
    @Size(min = 3)
    private String descriptionUZ;

    @NotNull(message = "descriptionRu not be null")
    @Size(min = 3)
    private String descriptionRu;

    @NotNull(message = "descriptionEn not be null")
    @Size(min = 3)
    private String descriptionEn;


}
