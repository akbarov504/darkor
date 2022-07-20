package uz.darkor.darkor_22.entity.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
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
}
