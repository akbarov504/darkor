package uz.darkor.darkor_22.entity.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Where;
import uz.darkor.darkor_22.entity.Auditable;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "is_deleted = false")
public class Price extends Auditable {
    private Double price;
    @Fetch(value = FetchMode.SELECT)
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> offersUz;

    @Fetch(value = FetchMode.SELECT)
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> offersRu;

    @Fetch(value = FetchMode.SELECT)
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> offersEn;


}
