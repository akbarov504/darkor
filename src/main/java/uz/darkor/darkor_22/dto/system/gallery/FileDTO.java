package uz.darkor.darkor_22.dto.system.gallery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.enums.ContentType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FileDTO extends GenericDTO {

    private Long size;
    private String originalName;
    private String GeneratedName;
    private String extension;
    private String url;
    private ContentType fileType;

}
