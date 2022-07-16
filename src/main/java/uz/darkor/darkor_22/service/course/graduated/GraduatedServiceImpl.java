package uz.darkor.darkor_22.service.course.graduated;

import org.springframework.stereotype.Service;
import uz.darkor.darkor_22.criteria.BaseCriteria;
import uz.darkor.darkor_22.dto.course.graduated.GraduatedCreateDTO;
import uz.darkor.darkor_22.dto.course.graduated.GraduatedGetDTO;
import uz.darkor.darkor_22.dto.course.graduated.GraduatedUpdateDTO;
import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.entity.course.Graduated;
import uz.darkor.darkor_22.exception.NotFoundException;
import uz.darkor.darkor_22.mapper.graduated.GraduatedMapper;
import uz.darkor.darkor_22.repository.course.CourseRepository;
import uz.darkor.darkor_22.repository.graduated.GraduatedRepository;
import uz.darkor.darkor_22.service.AbstractService;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class GraduatedServiceImpl extends AbstractService<GraduatedMapper, GraduatedRepository>
        implements GraduatedService {

    public final CourseRepository courseRepository;

    public GraduatedServiceImpl(GraduatedMapper mapper,
                                GraduatedRepository repository,
                                CourseRepository courseRepository) {
        super(mapper, repository);
        this.courseRepository = courseRepository;
    }

    @Override
    public GraduatedGetDTO create(GraduatedCreateDTO DTO) {
        Graduated graduated = mapper.fromCreateDTO(DTO);
        Graduated newGraduated = repository.save(graduated);
        return mapper.toGetDTO(newGraduated);
    }

    @Override
    public GraduatedGetDTO update(GraduatedUpdateDTO DTO) {
        Graduated target = checkExistenceAndGetByCode(DTO.getCode());
        Graduated graduated = mapper.fromUpdateDTO(DTO, target);
        Graduated updatedGraduated = repository.save(graduated);
        return mapper.toGetDTO(updatedGraduated);
    }

    @Override
    public Boolean delete(UUID key) {
        return repository.deleteByCode(key);
    }

    @Override
    public GraduatedGetDTO get(UUID key, String language) {
        Graduated graduated = checkExistenceAndGetByCode(key);
        return mapper.toGetDTO(graduated);
    }

    @Override
    public List<GraduatedGetDTO> list(BaseCriteria criteria, String language) {
        return mapper.toListDTO(repository.findAll());
    }

    private Graduated checkExistenceAndGetByCode(UUID code) {
        return repository.findByCode(code).orElseThrow(() -> new NotFoundException("GRADUATED_NOT_FOUND"));
    }

    @Override
    public List<GraduatedGetDTO> getByCourseCode(UUID code) {
        Course course = courseRepository.findByCode(code);
        if (Objects.isNull(course))
            throw new NotFoundException("COURSE_NOT_FOUND");
        List<Graduated> graduates = repository.findAllByCourse(course);
        return mapper.toListDTO(graduates);
    }
}
