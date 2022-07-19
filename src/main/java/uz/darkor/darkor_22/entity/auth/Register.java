package uz.darkor.darkor_22.entity.auth;

import lombok.*;
import org.hibernate.annotations.Where;
import uz.darkor.darkor_22.entity.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "register")
@Where(clause = "is_deleted = false")
public class Register extends Auditable {
    @Column(name = "first_name", nullable = false, updatable = false, length = 100)
    private String firstName;
    @Column(name = "last_name", nullable = false, updatable = false, length = 100)
    private String lastName;
    @Column(name = "father_name", nullable = false, updatable = false, length = 100)
    private String fatherName;
    @Column(name = "phone_number", nullable = false, updatable = false, length = 13)
    private String phoneNumber;
    @Column(name = "course_name", nullable = false, updatable = false)
    private String courseName;
}
