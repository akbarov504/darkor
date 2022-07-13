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

    @OneToOne(cascade = CascadeType.ALL)
    private Gallery gallery;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Course> courses;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "employee")
    private EmployeeDetail employeeDetail;


    public EmployeeGetDTO getLocalizationDto(String lang) {
        return switch (lang) {
            case "en" -> EmployeeGetDTO.builder()
                    .fullName(this.fullNameEn)
                    .type(this.type)
                    .gallery(this.gallery)
                    .courses(this.courses)
                    .build();
            case "ru" -> EmployeeGetDTO.builder()
                    .fullName(this.fullNameRu)
                    .type(this.type)
                    .gallery(this.gallery)
                    .courses(this.courses)
                    .build();
            default -> EmployeeGetDTO.builder()
                    .fullName(this.fullNameUz)
                    .type(this.type)
                    .gallery(this.gallery)
                    .courses(this.courses)
                    .build();
        };
    }
}
