package uz.darkor.darkor_22.entity.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import uz.darkor.darkor_22.entity.BaseEntity;

@Getter
@Setter
@AllArgsConstructor
public class Principal implements BaseEntity {
    private Long id;
    private String email;
    private boolean active;
    private boolean block;
}
