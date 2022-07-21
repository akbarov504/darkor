package uz.darkor.darkor_22.entity.system;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.darkor.darkor_22.dto.system.comment.CommentGetDTO;
import uz.darkor.darkor_22.entity.Auditable;
import uz.darkor.darkor_22.entity.course.Course;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends Auditable {
    @Column(nullable = false)
    private Byte stars;

    @Column(nullable = false)
    private String bodyUz;

    @Column(nullable = false)
    private String bodyRu;

    @Column(nullable = false)
    private String bodyEn;

    @Column(nullable = false)
    private String fullNameUz;

    @Column(nullable = false)
    private String fullNameRu;

    @Column(nullable = false)
    private String fullNameEn;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Gallery image;

    @ManyToOne()
    private Course course;
}
