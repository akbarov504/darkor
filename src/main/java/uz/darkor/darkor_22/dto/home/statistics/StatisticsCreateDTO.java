package uz.darkor.darkor_22.dto.home.statistics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.darkor.darkor_22.dto.BaseDTO;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatisticsCreateDTO implements BaseDTO {

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

    @NotNull(message = "type not be null")
    private String statisticsType;

}
