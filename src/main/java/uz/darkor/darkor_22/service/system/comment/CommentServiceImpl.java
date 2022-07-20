package uz.darkor.darkor_22.service.system.comment;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.darkor.darkor_22.criteria.system.comment.CommentCriteria;
import uz.darkor.darkor_22.dto.system.comment.CommentCreateDTO;
import uz.darkor.darkor_22.dto.system.comment.CommentGetDTO;
import uz.darkor.darkor_22.dto.system.comment.CommentLocalizationDTO;
import uz.darkor.darkor_22.dto.system.comment.CommentUpdateDTO;
import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.entity.system.Comment;
import uz.darkor.darkor_22.exception.NotFoundException;
import uz.darkor.darkor_22.exception.validator.BadRequestException;
import uz.darkor.darkor_22.mapper.system.comment.CommentMapper;
import uz.darkor.darkor_22.repository.course.CourseRepository;
import uz.darkor.darkor_22.repository.system.comment.CommentRepository;
import uz.darkor.darkor_22.service.AbstractService;
import uz.darkor.darkor_22.utils.BaseUtils;

import java.util.*;

@Service
public class CommentServiceImpl extends AbstractService<CommentMapper, CommentRepository> implements CommentService {

    private final CourseRepository courseRepository;

    public CommentServiceImpl(CommentMapper mapper, CommentRepository repository, CourseRepository courseRepository) {
        super(mapper, repository);
        this.courseRepository = courseRepository;
    }


    public CommentLocalizationDTO createMy(CommentCreateDTO DTO, String lang) {
        Comment comment = mapper.fromCreateDTO(DTO);
        Comment save = repository.save(comment);
        return mapper.toGetDTO(save).getLocalizationDto(lang);
    }

    public CommentLocalizationDTO updateMy(CommentUpdateDTO DTO, String lang) {
        Optional<Comment> byCode = repository.findById(DTO.getId());
        if (byCode.isEmpty()) throw new NotFoundException("Comment not found");
        Comment save = repository.save(mapper.fromUpdateDTO(DTO, byCode.get()));
        return mapper.toGetDTO(save).getLocalizationDto(lang);
    }

    public Boolean deleteMy(long id){
        try {
            repository.deleteById(id);
            return true;
        }catch(BadRequestException e){
            throw new BadRequestException("Cannot delete this comment");
        }
    }

    public CommentLocalizationDTO getMy(Long id, String language) {
        Optional<Comment> byCode = repository.findById(id);
        if (byCode.isEmpty()) {
            throw new NotFoundException("comment not found");
        }
        return mapper.toGetDTO(byCode.get()).getLocalizationDto(language);
    }

    public List<CommentLocalizationDTO> listMy(CommentCriteria criteria, String language) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        List<Comment> all = repository.findAll(request).stream().toList();
        return getLocalizedDtos(mapper.toListDTO(all));
    }


    public List<CommentLocalizationDTO> getByCourse(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isEmpty()) throw new NotFoundException("Comments course not found. Please enter correct code !");
        List<Comment> comments = repository.findAllByCourse(course.get());
        return getLocalizedDtos(mapper.toListDTO(comments));
    }

    @Override
    public CommentGetDTO create(CommentCreateDTO DTO) {
        return null;
    }

    @Override
    public CommentGetDTO update(CommentUpdateDTO DTO) {
        return null;
    }

    @Override
    public Boolean delete(UUID key) {
        return repository.deleteByCode(key);
    }

    @Override
    public CommentGetDTO get(UUID key, String language) {
      return null;
    }

    @Override
    public List<CommentGetDTO> list(CommentCriteria criteria, String language) {
return null;
    }

    public Long getSize() {
        return repository.count();
    }

    private List<CommentLocalizationDTO> getLocalizedDtos(List<CommentGetDTO> comments) {
        List<CommentLocalizationDTO> commentDtos = new ArrayList<>();
        for (CommentGetDTO e : comments) {
            commentDtos.add(e.getLocalizationDto(BaseUtils.getSessionLang()));
        }
        return commentDtos;
    }

}
