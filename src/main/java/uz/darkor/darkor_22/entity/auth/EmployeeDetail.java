package uz.darkor.darkor_22.entity.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import uz.darkor.darkor_22.dto.auth.employee_detail.EmployeeDetailGetDTO;
import uz.darkor.darkor_22.entity.Auditable;
import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.entity.course.Skill;
import uz.darkor.darkor_22.entity.system.Gallery;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "is_deleted = false")
@Table(indexes = @Index(name = "employee_detail_index", columnList = "code", unique = true))
public class EmployeeDetail extends Auditable {
    @Column(nullable = false)
    private String titleDescriptionUz;

    @Column(nullable = false)
    private String titleDescriptionRu;

    @Column(nullable = false)
    private String titleDescriptionEn;

    @Column(nullable = false)
    private String bodyDescriptionUz;

    @Column(nullable = false)
    private String bodyDescriptionRu;

    @Column(nullable = false)
    private String bodyDescriptionEn;

    @ManyToMany
    private List<Course> courses;

    @OneToMany
    private List<Skill> skills;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Gallery> gallery;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Employee employee;

    public EmployeeDetailGetDTO getLocalizationDto(String lang) {
        if (lang.equals("uz")) {
            return EmployeeDetailGetDTO.builder().titleDescription(this.titleDescriptionUz).bodyDescription(this.bodyDescriptionUz).galleries(this.gallery).courses(this.courses).skills(this.skills).employee(this.employee).build();
        } else if (lang.equals("ru")) {
            return EmployeeDetailGetDTO.builder().titleDescription(this.titleDescriptionRu).bodyDescription(this.bodyDescriptionRu).galleries(this.gallery).courses(this.courses).skills(this.skills).employee(this.employee).build();
        }
        return EmployeeDetailGetDTO.builder().titleDescription(this.titleDescriptionEn).bodyDescription(this.bodyDescriptionEn).galleries(this.gallery).courses(this.courses).skills(this.skills).employee(this.employee).build();
    }
}
