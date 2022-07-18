package uz.darkor.darkor_22.dto.home.statistics;

import lombok.Getter;
import lombok.Setter;
import uz.darkor.darkor_22.dto.GenericDTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Setter
@Getter
public class StatisticsUpdateDTO extends GenericDTO {

    @NotNull(message = "number not be null")
    private String number;


    @NotNull(message = "number not be null")
    @Size(min = 3,max =250 )
    private String titleUz;

    @NotNull(message = "number not be null")
    @Size(min = 3,max =250 )
    private String titleRu;

    @NotNull(message = "number not be null")
    @Size(min = 3,max =250 )
    private String titleEn;

    @NotNull(message = "number not be null")
    private String descriptionUz;

    @NotNull(message = "number not be null")
    private String descriptionRu;

    @NotNull(message = "number not be null")
    private String descriptionEn;

    public StatisticsUpdateDTO(@NotNull(message = "code cannot be null") UUID code, String number, String titleUz, String titleRu, String titleEn, String descriptionUz, String descriptionRu, String descriptionEn) {
        super(code);
        this.number = number;
        this.titleUz = titleUz;
        this.titleRu = titleRu;
        this.titleEn = titleEn;
        this.descriptionUz = descriptionUz;
        this.descriptionRu = descriptionRu;
        this.descriptionEn = descriptionEn;
    }
}
