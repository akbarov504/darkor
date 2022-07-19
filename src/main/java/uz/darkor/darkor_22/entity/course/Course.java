package uz.darkor.darkor_22.entity.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;
import uz.darkor.darkor_22.dto.system.gallery.GalleryDTO;
import uz.darkor.darkor_22.entity.Auditable;
import uz.darkor.darkor_22.entity.auth.Employee;
import uz.darkor.darkor_22.entity.system.Gallery;
import uz.darkor.darkor_22.utils.BaseUtils;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinTable(uniqueConstraints = @UniqueConstraint(columnNames = {"course_id", "image_uz_id"}))
    private List<Gallery> imageUz;

    @Fetch(FetchMode.SELECT)
    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinTable(uniqueConstraints = @UniqueConstraint(columnNames = {"course_id", "image_ru_id"}))
    private List<Gallery> imageRu;

    @Fetch(FetchMode.SELECT)
    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinTable(uniqueConstraints = @UniqueConstraint(columnNames = {"course_id", "image_en_id"}))
    private List<Gallery> imageEn;


    public Course(String nameUz,
                  String nameRu,
                  String nameEn,
                  String descriptionUz,
                  String descriptionEn,
                  String descriptionRu) {
        this.nameUz = nameUz;
        this.nameRu = nameRu;
        this.nameEn = nameEn;
        this.descriptionUz = descriptionUz;
        this.descriptionEn = descriptionEn;
        this.descriptionRu = descriptionRu;
    }

    public CourseGetDTO getLocalizationDto(String lang) {
        Gallery gallery =new Gallery();
        if (lang.equals("uz")) {
            return CourseGetDTO.builder()
                    .id(getId())
                    .name(this.nameUz)
                    .description(this.descriptionUz)
                    .galleries(gallery.getListFileDTO(this.imageUz))
                    .build();
        } else if (lang.equals("ru")) {
            return CourseGetDTO.builder()
                    .id(getId())
                    .name(this.nameRu)
                    .description(this.descriptionRu)
                    .galleries(gallery.getListFileDTO(this.imageRu))
                    .build();
        }
        return CourseGetDTO.builder()
                .id(getId())
                .name(this.nameEn)
                .description(this.descriptionEn)
                .galleries(gallery.getListFileDTO(this.imageEn))
                .build();
    }

    public List<CourseGetDTO> getListLocalizedDtos(List<Course> courses) {
        List<CourseGetDTO> courseGetDTOS = new ArrayList<>();
        for (Course cours : courses) {
            courseGetDTOS.add(cours.getLocalizationDto(BaseUtils.getSessionLang()));
        }
        return courseGetDTOS;
    }

}
