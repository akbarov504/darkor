package uz.darkor.darkor_22.dto.auth.token;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthTokenGetDTO extends GenericDTO {
    private String type;
    private String token;
}
