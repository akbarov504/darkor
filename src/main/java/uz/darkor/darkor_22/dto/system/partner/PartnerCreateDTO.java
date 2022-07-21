package uz.darkor.darkor_22.dto.system.partner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.darkor.darkor_22.dto.BaseDTO;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PartnerCreateDTO implements BaseDTO {

    @NotNull(message = "logo doesn't be null")
    private FileDTO logo;
    @NotNull(message = "link doesn't be null")
    private String link;
}
