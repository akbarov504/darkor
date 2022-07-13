package uz.darkor.darkor_22.dto.system.gallery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import uz.darkor.darkor_22.dto.BaseDTO;
import uz.darkor.darkor_22.enums.ContentType;


import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GalleryDTO implements BaseDTO {

    private MultipartFile file;

    @NotNull(message = "type doesn't be null")
    private ContentType type;



}
