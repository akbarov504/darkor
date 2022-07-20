package uz.darkor.darkor_22.dto.home.statistics;

import lombok.*;
import uz.darkor.darkor_22.enums.StatisticsType;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class StatisticsLocalizedDTO {

    private Long id;
    private String title;
    private String description;
    private String number;
    private StatisticsType statisticsType;
}
