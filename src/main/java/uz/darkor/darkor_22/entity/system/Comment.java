package uz.darkor.darkor_22.entity.system;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.darkor.darkor_22.dto.system.comment.CommentGetDTO;
import uz.darkor.darkor_22.entity.Auditable;
import uz.darkor.darkor_22.entity.course.Course;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends Auditable {
    @Column(nullable = false)
    private Byte stars;

    @Column(nullable = false)
    private String bodyUz;

    @Column(nullable = false)
    private String bodyRu;

    @Column(nullable = false)
    private String bodyEn;

    @Column(nullable = false)
    private String fullNameUz;

    @Column(nullable = false)
    private String fullNameRu;

    @Column(nullable = false)
    private String fullNameEn;

    @OneToOne
    private Gallery image;

    @ManyToOne
    private Course course;

    public CommentGetDTO getLocalizationDto(String lang) {
        if (lang.equals("uz")) {
            return CommentGetDTO.builder().stars(this.stars).body(this.bodyUz).fullName(this.fullNameUz).gallery(this.image).course(this.course).build();
        } else if (lang.equals("ru")) {
            return CommentGetDTO.builder().stars(this.stars).body(this.bodyRu).fullName(this.fullNameRu).gallery(this.image).course(this.course).build();
        }
        return CommentGetDTO.builder().stars(this.stars).body(this.bodyEn).fullName(this.fullNameEn).gallery(this.image).course(this.course).build();
    }
}
