package uz.darkor.darkor_22.entity.home;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.darkor.darkor_22.dto.home.post.PostGetDTO;
import uz.darkor.darkor_22.entity.Auditable;
import uz.darkor.darkor_22.entity.system.Gallery;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post extends Auditable {
    @OneToOne(cascade = CascadeType.ALL)
    private Gallery galleryUz;

    @OneToOne(cascade = CascadeType.ALL)
    private Gallery galleryRu;

    @OneToOne(cascade = CascadeType.ALL)
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
            return PostGetDTO.builder().title(this.titleUz).description(this.descriptionUz).gallery(this.galleryUz).build();
        } else if (lang.equals("ru")) {
            return PostGetDTO.builder().title(this.titleRu).description(this.descriptionRu).gallery(this.galleryRu).build();
        }
        return PostGetDTO.builder().title(this.titleEn).description(this.descriptionEn).gallery(this.galleryEn).build();
    }
}
