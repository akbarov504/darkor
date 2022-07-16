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
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Gallery galleryUz;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Gallery galleryRu;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
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

    public PostGetDTO getLocalizationDto(String lang) {
        if (lang.equals("uz")) {
            return PostGetDTO.builder().code(this.getCode()).title(this.titleUz).description(this.descriptionUz).gallery(this.galleryUz).build();
        } else if (lang.equals("ru")) {
            return PostGetDTO.builder().code(this.getCode()).title(this.titleRu).description(this.descriptionRu).gallery(this.galleryRu).build();
        }
        return PostGetDTO.builder().code(this.getCode()).title(this.titleEn).description(this.descriptionEn).gallery(this.galleryEn).build();
    }
}
