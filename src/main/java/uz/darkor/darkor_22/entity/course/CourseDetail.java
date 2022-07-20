package uz.darkor.darkor_22.entity.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import uz.darkor.darkor_22.dto.course.course_detail.CourseDetailGetDTO;
import uz.darkor.darkor_22.entity.Auditable;
import uz.darkor.darkor_22.entity.auth.Employee;
import uz.darkor.darkor_22.entity.system.Comment;
import uz.darkor.darkor_22.entity.system.FAQ;
import uz.darkor.darkor_22.entity.system.Gallery;
import uz.darkor.darkor_22.mapper.system.file.FileMapper;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseDetail extends Auditable {

    @Column(nullable = false, columnDefinition = "text")
    private String titleDescriptionUz;
    @Column(nullable = false, columnDefinition = "text")
    private String titleDescriptionRu;
    @Column(nullable = false, columnDefinition = "text")
    private String titleDescriptionEn;
    @Column(nullable = false, columnDefinition = "text", length = 1600)
    private String bodyDescriptionUz;
    @Column(nullable = false, columnDefinition = "text", length = 1600)
    private String bodyDescriptionRu;
    @Column(nullable = false, columnDefinition = "text", length = 1600)
    private String bodyDescriptionEn;

    @Fetch(FetchMode.SELECT)
    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinTable(uniqueConstraints = @UniqueConstraint(columnNames = {"course_detail_id", "file_uz_id"}))
    private List<Gallery> fileUz;

    @Fetch(FetchMode.SELECT)
    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinTable(uniqueConstraints = @UniqueConstraint(columnNames = {"course_detail_id", "file_ru_id"}))
    private List<Gallery> fileRu;

    @Fetch(FetchMode.SELECT)
    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinTable(uniqueConstraints = @UniqueConstraint(columnNames = {"course_detail_id", "file_en_id"}))
    private List<Gallery> fileEn;

    @OneToOne
    private Price price;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Course course;

}
