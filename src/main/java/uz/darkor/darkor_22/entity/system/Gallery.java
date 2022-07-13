package uz.darkor.darkor_22.entity.system;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.darkor.darkor_22.entity.Auditable;
import uz.darkor.darkor_22.enums.ContentType;

import javax.persistence.*;

@Entity
@Table(indexes = @Index(name = "gallery_index", columnList = "code", unique = true))
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
    private String GeneratedName;

    @Column(nullable = false)
    private String extension;

    @Column(nullable = false)
    private String path;

    @Column(nullable = false)
    private String url;

    @Enumerated(value = EnumType.STRING)
    private ContentType fileType;
}
