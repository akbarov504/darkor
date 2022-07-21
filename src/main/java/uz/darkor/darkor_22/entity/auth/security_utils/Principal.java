package uz.darkor.darkor_22.entity.auth.security_utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import uz.darkor.darkor_22.entity.BaseEntity;

/**
 * @Author Aziza Tojiboyeva
 */
@Setter
@Getter
@AllArgsConstructor
public class Principal implements BaseEntity {
    private Long id;
    private String email;
    private boolean active;
    private boolean block;
}
