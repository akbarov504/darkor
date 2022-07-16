package uz.darkor.darkor_22.entity.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;
import uz.darkor.darkor_22.entity.Auditable;
import uz.darkor.darkor_22.entity.system.Gallery;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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

    @Fetch(FetchMode.SELECT)
    @OneToMany(cascade = CascadeType.REMOVE,  fetch = FetchType.EAGER)
    private List<Gallery> imageUz;

    @Fetch(FetchMode.SELECT)
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Gallery> imageRu;

    @Fetch(FetchMode.SELECT)
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Gallery> imageEn;

    public CourseGetDTO getLocalizationDto(String lang) {
        if (lang.equals("uz")) {
            return CourseGetDTO.builder().name(this.nameUz).description(this.descriptionUz).galleries(this.imageUz).build();
        } else if (lang.equals("ru")) {
            return CourseGetDTO.builder().name(this.nameRu).description(this.descriptionRu).galleries(this.imageRu).build();
        }
        return CourseGetDTO.builder().name(this.nameEn).description(this.descriptionEn).galleries(this.imageEn).build();
    }

    public Course(String nameUz, String nameRu, String nameEn, String descriptionUz, String descriptionEn, String descriptionRu) {
        this.nameUz = nameUz;
        this.nameRu = nameRu;
        this.nameEn = nameEn;
        this.descriptionUz = descriptionUz;
        this.descriptionEn = descriptionEn;
        this.descriptionRu = descriptionRu;
    }
}
