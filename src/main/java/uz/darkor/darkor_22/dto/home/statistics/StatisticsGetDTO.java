package uz.darkor.darkor_22.dto.home.statistics;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StatisticsGetDTO extends GenericDTO {
    private String title;
    private String description;
    private String number;
}
