package uz.darkor.darkor_22.dto.home.statistics;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class StatisticsGetDTO extends GenericDTO {

    private String title;
    private String description;
    private String number;

    @Builder()
    public StatisticsGetDTO(@NotNull(message = "code cannot be null") UUID code, String title, String description, String number) {
        super(code);
        this.title = title;
        this.description = description;
        this.number = number;
    }
}
