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
public class CommentServiceImpl extends AbstractService<CommentMapper, CommentRepository>{

    private final CourseRepository courseRepository;

    public CommentServiceImpl(CommentMapper mapper, CommentRepository repository, CourseRepository courseRepository) {
        super(mapper, repository);
        this.courseRepository = courseRepository;
    }


    public CommentLocalizationDTO createMy(CommentCreateDTO DTO, String lang) {
        Comment comment = mapper.fromCreateDTO(DTO);
        if (Objects.nonNull(DTO.getCourse())){
            Optional<Course> byId = courseRepository.findById(DTO.getCourse().getId());
            if (byId.isEmpty()) throw new NotFoundException("course not found please try again");
            comment.setCourse(byId.get());
        }else {
            comment.setCourse(null);
        }
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
        List<CommentLocalizationDTO> commentDtos = new ArrayList<>();
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        List<Comment> all = repository.findAll(request).stream().toList();
        for (Comment e : all) {
            commentDtos.add(mapper.toGetDTO(e).getLocalizationDto(language));
        }
        return commentDtos;
    }


    public List<CommentLocalizationDTO> getByCourse(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isEmpty()) throw new NotFoundException("Comments course not found. Please enter correct code !");
        List<Comment> comments = repository.findAllByCourse(course.get());
        return getLocalizedDtos(mapper.toGetListDtoMy(comments));
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
