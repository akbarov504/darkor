package uz.darkor.darkor_22.dto.course.course_detail;

import lombok.*;
import uz.darkor.darkor_22.dto.BaseDTO;
import uz.darkor.darkor_22.entity.auth.Employee;
import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.entity.course.Price;
import uz.darkor.darkor_22.entity.course.Skill;
import uz.darkor.darkor_22.entity.system.Comment;
import uz.darkor.darkor_22.entity.system.FAQ;
import uz.darkor.darkor_22.entity.system.Gallery;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseDetailCreateDTO implements BaseDTO {
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
}
