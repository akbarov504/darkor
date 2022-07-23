package uz.darkor.darkor_22.entity.auth.token;

import lombok.*;
import uz.darkor.darkor_22.entity.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "auth_token")
public class AuthToken extends Auditable {
    @Column(name = "user_code", nullable = false, updatable = false)
    private UUID userCode;

    @Column(name = "token", nullable = false, updatable = false, columnDefinition = "TEXT")
    private String token;

    @Column(name = "duration", nullable = false)
    private Date duration;

    @Column(name = "type", nullable = false, length = 120)
    private String type;
}
