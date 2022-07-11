package uz.darkor.darkor_22.entity.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.darkor.darkor_22.entity.Auditable;
import uz.darkor.darkor_22.entity.system.Gallery;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Graduated extends Auditable {
    @ManyToOne
    private Course course;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Gallery> galleries;
}
