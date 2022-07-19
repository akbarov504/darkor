package uz.darkor.darkor_22.entity.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeGetDTO;
import uz.darkor.darkor_22.entity.Auditable;
import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.entity.system.Gallery;
import uz.darkor.darkor_22.enums.EmployeeType;
import uz.darkor.darkor_22.utils.BaseUtils;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "is_deleted = false")
@Table(indexes = @Index(name = "employee_index", columnList = "code", unique = true))
public class Employee extends Auditable {
    @Column(nullable = false)
    private String fullNameUz;

    @Column(nullable = false)
    private String fullNameRu;

    @Column(nullable = false)
    private String fullNameEn;

    @Enumerated(EnumType.STRING)
    private EmployeeType type;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Gallery gallery;

    @ManyToMany(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    private List<Course> courses;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "employee")
    private EmployeeDetail employeeDetail;

    public Employee(String fullNameUz,
                    String fullNameRu,
                    String fullNameEn,
                    EmployeeType type,
                    Gallery gallery,
                    List<Course> courses) {
        this.fullNameUz = fullNameUz;
        this.fullNameRu = fullNameRu;
        this.fullNameEn = fullNameEn;
        this.type = type;
        this.gallery = gallery;
        this.courses = courses;
    }

    public EmployeeGetDTO getLocalizationDto() {
        String lang = BaseUtils.getSessionLang();
        return switch (lang) {
            case "en" -> EmployeeGetDTO.builder()
                    .code(this.getCode())
                    .fullName(this.fullNameEn)
                    .type(this.type)
                    .gallery(this.gallery)
                    .courses(this.courses)
                    .build();
            case "ru" -> EmployeeGetDTO.builder()
                    .code(this.getCode())
                    .fullName(this.fullNameRu)
                    .type(this.type)
                    .gallery(this.gallery)
                    .courses(this.courses)
                    .build();
            default -> EmployeeGetDTO.builder()
                    .code(this.getCode())
                    .fullName(this.fullNameUz)
                    .type(this.type)
                    .gallery(this.gallery)
                    .courses(this.courses)
                    .build();
        };
    }
}
