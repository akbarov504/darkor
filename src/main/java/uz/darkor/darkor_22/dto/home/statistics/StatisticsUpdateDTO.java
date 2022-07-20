package uz.darkor.darkor_22.dto.home.statistics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.darkor.darkor_22.dto.GenericDTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StatisticsUpdateDTO extends GenericDTO {

    @NotNull(message = "id not be null")
    private Long id;

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
