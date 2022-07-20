package uz.darkor.darkor_22.entity.home;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.darkor.darkor_22.dto.home.post.PostGetDTO;
import uz.darkor.darkor_22.entity.Auditable;
import uz.darkor.darkor_22.entity.system.Gallery;

import javax.persistence.*;

@Getter
@Setter
@Table(indexes = @Index(name = "post_index", columnList = "code", unique = true))
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post extends Auditable {

    @OneToOne(cascade = CascadeType.MERGE)
    private Gallery galleryUz;

    @OneToOne(cascade = CascadeType.MERGE)
    private Gallery galleryRu;

    @OneToOne(cascade = CascadeType.MERGE)
    private Gallery galleryEn;

    @Column(nullable = false)
    private String titleUz;

    @Column(nullable = false)
    private String titleRu;

    @Column(nullable = false)
    private String titleEn;

    @Column(nullable = false)
    private String descriptionUz;

    @Column(nullable = false)
    private String descriptionRu;

    @Column(nullable = false)
    private String descriptionEn;

}
