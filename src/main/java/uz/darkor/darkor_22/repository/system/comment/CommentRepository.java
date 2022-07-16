package uz.darkor.darkor_22.repository.system.comment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.entity.system.Comment;
import uz.darkor.darkor_22.repository.BaseRepository;

import java.util.List;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, Long>,BaseRepository {

    Boolean deleteByCode(UUID code);

    Comment findByCode(UUID code);

    @Query("from Comment where course = :course")
    List<Comment> findAllByCourse(@Param("course") Course course);


}
