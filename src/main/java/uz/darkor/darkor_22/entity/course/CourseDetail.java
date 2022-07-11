package uz.darkor.darkor_22.entity.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.darkor.darkor_22.dto.course.course_detail.CourseDetailGetDTO;
import uz.darkor.darkor_22.entity.Auditable;
import uz.darkor.darkor_22.entity.auth.Employee;
import uz.darkor.darkor_22.entity.system.Comment;
import uz.darkor.darkor_22.entity.system.FAQ;
import uz.darkor.darkor_22.entity.system.Gallery;

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

    @OneToMany(cascade = CascadeType.ALL)
    private List<Gallery> fileUz;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Gallery> fileRu;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Gallery> fileEn;

    @OneToMany
    private List<Skill> skills;

    @ManyToMany
    private List<Employee> employees;
    @OneToMany
    private List<Comment> comments;
    @OneToOne
    private Price price;
    @OneToMany
    private List<FAQ> faq;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Course course;

    public CourseDetailGetDTO getLocalizationDto(String lang) {
        if (lang.equals("uz")) {
            return CourseDetailGetDTO.builder().titleDescription(this.titleDescriptionUz).bodyDescription(this.bodyDescriptionUz).galleries(this.fileUz).course(this.course).skills(this.skills).employees(this.employees).build();
        } else if (lang.equals("ru")) {
            return CourseDetailGetDTO.builder().titleDescription(this.titleDescriptionRu).bodyDescription(this.bodyDescriptionRu).galleries(this.fileRu).course(this.course).skills(this.skills).employees(this.employees).build();
        }
        return CourseDetailGetDTO.builder().titleDescription(this.titleDescriptionEn).bodyDescription(this.bodyDescriptionEn).galleries(this.fileEn).course(this.course).skills(this.skills).employees(this.employees).build();
    }
}
