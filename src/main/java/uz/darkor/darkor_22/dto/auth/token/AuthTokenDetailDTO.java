package uz.darkor.darkor_22.dto.auth.token;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthTokenDetailDTO extends GenericDTO {
    private UUID userCode;
    private String token;
    private Date duration;
    private String type;
}
