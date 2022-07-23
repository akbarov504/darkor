package uz.darkor.darkor_22.dto.auth.token;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthTokenGetDTO extends GenericDTO {
    private String type;
    private String token;
}
