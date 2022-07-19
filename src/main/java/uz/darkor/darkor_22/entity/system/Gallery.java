package uz.darkor.darkor_22.entity.system;


import lombok.*;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;
import uz.darkor.darkor_22.entity.Auditable;
import uz.darkor.darkor_22.enums.ContentType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(indexes = @Index(name = "gallery_index", columnList = "code"))
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Gallery extends Auditable {
    @Column(nullable = false)
    private Long size;

    @Column(nullable = false)
    private String originalName;

    @Column(nullable = false)
    private String generatedName;

    @Column(nullable = false)
    private String extension;

    //    @Column(nullable = false)
    private String path;

    //    @Column(nullable = false)
    private String url;

    @Enumerated(value = EnumType.STRING)
    private ContentType fileType;

    public FileDTO getFileDTO() {
        return FileDTO.builder()
                .id(this.getId())
                .code(this.getCode())
                .extension(this.extension)
                .fileType(this.fileType)
                .generatedName(this.generatedName)
                .originalName(this.originalName)
                .size(this.size)
                .url(this.url)
                .build();
    }

    public static List<FileDTO> getListFileDTO(List<Gallery> galleries) {
        List<FileDTO> fileDTOS = new ArrayList<>();
        for (Gallery gallery : galleries) {
            fileDTOS.add(gallery.getFileDTO());
        }
        return fileDTOS;
    }


}
