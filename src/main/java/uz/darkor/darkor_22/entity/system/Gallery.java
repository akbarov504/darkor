package uz.darkor.darkor_22.entity.system;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.darkor.darkor_22.entity.Auditable;
import uz.darkor.darkor_22.enums.ContentType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Gallery extends Auditable {
    @Column(nullable = false)
    private Double size;

    @Column(nullable = false)
    private String originalName;

    @Column(nullable = false)
    private String pathName;

    @Column(nullable = false)
    private String extension;

    @Column(nullable = false)
    private String path;

    @Enumerated(value = EnumType.STRING)
    private ContentType fileType;
}
