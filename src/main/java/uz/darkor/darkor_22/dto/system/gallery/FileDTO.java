package uz.darkor.darkor_22.dto.system.gallery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.enums.ContentType;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class FileDTO extends GenericDTO {

    private Long id;
    private Long size;
    private String originalName;
    private String GeneratedName;
    private String extension;
    private String url;
    private ContentType fileType;

    public FileDTO(@NotNull(message = "code cannot be null") UUID code, Long id, Long size, String originalName, String generatedName, String extension, String url, ContentType fileType) {
        super(code);
        this.id = id;
        this.size = size;
        this.originalName = originalName;
        GeneratedName = generatedName;
        this.extension = extension;
        this.url = url;
        this.fileType = fileType;
    }
}
