package uz.darkor.darkor_22.dto.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.darkor.darkor_22.dto.GenericDTO;

import java.util.UUID;

@Setter
@Getter
public class PasswordDto extends GenericDTO {
    private Long id;
    private String oldPass;
    private String newPassword;

    @Builder
    public PasswordDto(UUID code, Long id, String oldPass, String newPassword) {
        super(code);
        this.id = id;
        this.oldPass = oldPass;
        this.newPassword = newPassword;
    }
}
