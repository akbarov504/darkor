package uz.darkor.darkor_22.dto.home.statistics;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.enums.StatisticsType;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class StatisticsGetDTO extends GenericDTO {

    private Long id;

    private String number;
    private String titleUz;

    private String titleEn;

    private String titleRu;
    private String descriptionUz;

    private String descriptionRu;

    private String descriptionEn;

    private StatisticsType statisticsType;

    public StatisticsLocalizedDTO getLocalizationDto(String lang) {

        if (lang.equals("uz")) {
            return StatisticsLocalizedDTO.builder().id(id).number(number).description(descriptionUz).title(titleUz).statisticsType(statisticsType).build();
        } else if (lang.equals("ru")) {
            return StatisticsLocalizedDTO.builder().id(id).number(number).description(descriptionRu).title(titleRu).statisticsType(statisticsType).build();
        }
        return StatisticsLocalizedDTO.builder().id(id).number(number).description(descriptionEn).title(titleEn).statisticsType(statisticsType).build();

    }
}
