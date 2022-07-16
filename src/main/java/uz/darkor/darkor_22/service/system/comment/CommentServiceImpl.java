package uz.darkor.darkor_22.service.system.comment;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.darkor.darkor_22.criteria.system.comment.CommentCriteria;
import uz.darkor.darkor_22.dto.system.comment.CommentCreateDTO;
import uz.darkor.darkor_22.dto.system.comment.CommentGetDTO;
import uz.darkor.darkor_22.dto.system.comment.CommentUpdateDTO;
import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.entity.system.Comment;
import uz.darkor.darkor_22.exception.NotFoundException;
import uz.darkor.darkor_22.mapper.system.comment.CommentMapper;
import uz.darkor.darkor_22.repository.course.CourseRepository;
import uz.darkor.darkor_22.repository.system.comment.CommentRepository;
import uz.darkor.darkor_22.service.AbstractService;
import uz.darkor.darkor_22.service.GenericCUDService;
import uz.darkor.darkor_22.service.GenericGLService;
import uz.darkor.darkor_22.utils.BaseUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class CommentServiceImpl extends AbstractService<CommentMapper, CommentRepository> implements CommentService {

    private final CourseRepository courseRepository;

    public CommentServiceImpl(CommentMapper mapper, CommentRepository repository, CourseRepository courseRepository) {
        super(mapper, repository);
        this.courseRepository = courseRepository;
    }

    @Override
    public CommentGetDTO create(CommentCreateDTO DTO) {
        Comment comment = mapper.fromCreateDTO(DTO);
        Comment save = repository.save(comment);
        return mapper.toGetDTO(comment);
    }

    @Override
    public CommentGetDTO update(CommentUpdateDTO DTO) {
        Comment byCode = repository.findByCode(DTO.getCode());
        if (Objects.isNull(byCode)) throw  new NotFoundException("Comment not found");
        Comment save = repository.save(mapper.fromUpdateDTO(DTO,byCode));
        return save.getLocalizationDto(BaseUtils.getSessionLang());
    }

    @Override
    public Boolean delete(UUID key) {
        return repository.deleteByCode(key);
    }


    @Override
    public CommentGetDTO get(UUID key) {
        Comment byCode = repository.findByCode(key);
        if (!Objects.nonNull(byCode)) {
            throw new NotFoundException("comment not found");
        }
        return mapper.toGetDTO(byCode);
    }

    @Override
    public List<CommentGetDTO> list(CommentCriteria criteria) {

        List<Comment> all = repository.findAll();
        return getLocalizedDtos(all);
    }

    public Long getSize(){
        return repository.count();
    }

    public List<CommentGetDTO> getByCourse(UUID courseCode) {

        Course course = courseRepository.findByCode(courseCode);
        if (Objects.isNull(course))
            throw new NotFoundException("Comments course not found. Please enter correct code !");
        List<Comment> comments = repository.findAllByCourse(course);
        List<CommentGetDTO> localizedDtos = getLocalizedDtos(comments);
        return localizedDtos;
    }

    private List<CommentGetDTO> getLocalizedDtos(List<Comment> comments) {
        List<CommentGetDTO> commentDtos = new ArrayList<>();
        for (Comment e : comments) {
            commentDtos.add(e.getLocalizationDto(BaseUtils.getSessionLang()));
        }
        return commentDtos;
    }

}
