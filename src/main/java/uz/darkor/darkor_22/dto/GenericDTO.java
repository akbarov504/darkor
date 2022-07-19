package uz.darkor.darkor_22.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GenericDTO implements BaseDTO {
//    @NotNull(message = "code cannot be null")
    private UUID code;
}
