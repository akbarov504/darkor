package uz.darkor.darkor_22.dto.system.partner;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class PartnerUpdateDTO extends GenericDTO {

    private Long id;
    @NotNull(message = "logo doesn't be null")
    private FileDTO logo;
    @NotNull(message = "logo doesn't be null")
    private String link;

    public PartnerUpdateDTO(@NotNull(message = "code cannot be null") UUID code, Long id, FileDTO logo, String link) {
        super(code);
        this.id = id;
        this.logo = logo;
        this.link = link;
    }
}
