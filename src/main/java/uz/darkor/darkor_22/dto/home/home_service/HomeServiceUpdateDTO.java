package uz.darkor.darkor_22.dto.home.home_service;

import lombok.Getter;
import lombok.Setter;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;
import uz.darkor.darkor_22.entity.system.Gallery;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Setter
@Getter
public class HomeServiceUpdateDTO extends GenericDTO {

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

    public HomeServiceUpdateDTO(@NotNull(message = "code cannot be null") UUID code, FileDTO galleryUz, FileDTO galleryRu, FileDTO galleryEn, String titleUz, String titleRU, String titleEn, String descriptionUZ, String descriptionRu, String descriptionEn) {
        super(code);
        this.galleryUz = galleryUz;
        this.galleryRu = galleryRu;
        this.galleryEn = galleryEn;
        this.titleUz = titleUz;
        this.titleRU = titleRU;
        this.titleEn = titleEn;
        this.descriptionUZ = descriptionUZ;
        this.descriptionRu = descriptionRu;
        this.descriptionEn = descriptionEn;
    }
}
