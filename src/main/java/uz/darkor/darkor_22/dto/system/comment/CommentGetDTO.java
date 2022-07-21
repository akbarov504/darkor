package uz.darkor.darkor_22.dto.system.comment;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;
import uz.darkor.darkor_22.dto.course.course.CourseLocalizationDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;
import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.entity.system.Gallery;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CommentGetDTO extends GenericDTO {

    private Long id;
    private Byte stars;

    private String bodyUz;

    private String bodyRu;

    private String bodyEn;

    private String fullNameUz;

    private String fullNameRu;

    private String fullNameEn;

    private FileDTO image;

    private CourseGetDTO course;


    public CommentLocalizationDTO getLocalizationDto(String lang) {

        if (lang.equals("uz")) {
            return CommentLocalizationDTO.builder().stars(this.stars).body(this.bodyUz).fullName(this.fullNameUz).gallery(this.image).course(this.course.getLocalizationDto("uz")).build();
        } else if (lang.equals("ru")) {
            return CommentLocalizationDTO.builder().stars(this.stars).body(this.bodyRu).fullName(this.fullNameRu).gallery(this.image).course(this.course.getLocalizationDto("ru")).build();
        }
        return CommentLocalizationDTO.builder().stars(this.stars).body(this.bodyEn).fullName(this.fullNameEn).gallery(this.image).course(this.course.getLocalizationDto("en")).build();
    }

}
