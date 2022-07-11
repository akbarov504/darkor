package uz.darkor.darkor_22.entity.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;
import uz.darkor.darkor_22.entity.Auditable;
import uz.darkor.darkor_22.entity.system.Gallery;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course extends Auditable {
    @Column(nullable = false)
    private String nameUz;

    @Column(nullable = false)
    private String nameRu;

    @Column(nullable = false)
    private String nameEn;

    @Column(nullable = false)
    private String descriptionUz;

    @Column(nullable = false)
    private String descriptionEn;

    @Column(nullable = false)
    private String descriptionRu;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Gallery> imageUz;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Gallery> imageRu;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Gallery> imageEn;

    public CourseGetDTO getLocalizationDto(String lang) {
        if (lang.equals("uz")) {
            return CourseGetDTO.builder().name(this.nameUz).description(this.descriptionUz).galleries(this.imageUz).build();
        } else if (lang.equals("ru")) {
            return CourseGetDTO.builder().name(this.nameRu).description(this.descriptionRu).galleries(this.imageRu).build();
        }
        return CourseGetDTO.builder().name(this.nameEn).description(this.descriptionEn).galleries(this.imageEn).build();
    }
}
