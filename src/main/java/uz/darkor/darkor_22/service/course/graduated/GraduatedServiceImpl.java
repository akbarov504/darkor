package uz.darkor.darkor_22.service.course.graduated;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.darkor.darkor_22.criteria.graduated.GraduatedCriteria;
import uz.darkor.darkor_22.dto.course.graduated.GraduatedCreateDTO;
import uz.darkor.darkor_22.dto.course.graduated.GraduatedLocalizedDTO;
import uz.darkor.darkor_22.dto.course.graduated.GraduatedUpdateDTO;
import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.entity.course.Graduated;
import uz.darkor.darkor_22.exception.NotFoundException;
import uz.darkor.darkor_22.mapper.graduated.GraduatedMapper;
import uz.darkor.darkor_22.repository.course.CourseRepository;
import uz.darkor.darkor_22.repository.graduated.GraduatedRepository;
import uz.darkor.darkor_22.service.AbstractService;

import java.util.ArrayList;
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
    public GraduatedLocalizedDTO create(GraduatedCreateDTO DTO) {
        Graduated graduated = mapper.fromCreateDTO(DTO);
        Graduated newGraduated = repository.save(graduated);
        return mapper.toGetDTO(newGraduated).getLocalizationDto("uz");
    }

    @Override
    public GraduatedLocalizedDTO update(GraduatedUpdateDTO DTO) {
        Graduated target = checkExistenceAndGetByCode(DTO.getCode());
        Graduated graduated = mapper.fromUpdateDTO(DTO, target);
        Graduated updatedGraduated = repository.save(graduated);
        return mapper.toGetDTO(updatedGraduated).getLocalizationDto("uz");
    }

    @Override
    public Boolean delete(UUID key) {
        try {
            Graduated graduated = repository.findByCode(key).orElseThrow(() -> {
                throw new NotFoundException("Graduated not found !");
            });
            graduated.setDeleted(true);
            repository.save(graduated);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public GraduatedLocalizedDTO get(UUID key, String language) {
        Graduated graduated = checkExistenceAndGetByCode(key);
        return mapper.toGetDTO(graduated).getLocalizationDto(language);
    }

    @Override
    public List<GraduatedLocalizedDTO> list(GraduatedCriteria criteria, String language) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        return getLocalizedDTOs(repository.findAll(request).getContent(), language);
    }

    private Graduated checkExistenceAndGetByCode(UUID code) {
        return repository.findByCode(code).orElseThrow(() -> new NotFoundException("GRADUATED_NOT_FOUND"));
    }

    @Override
    public List<GraduatedLocalizedDTO> getByCourseCode(UUID code) {
        Course course = courseRepository.findByCode(code);
        if (Objects.isNull(course))
            throw new NotFoundException("COURSE_NOT_FOUND");
        List<Graduated> graduates = repository.findAllByCourse(course);
        return getLocalizedDTOs(graduates, "uz");
    }

    private List<GraduatedLocalizedDTO> getLocalizedDTOs(List<Graduated> graduated, String lang) {
        List<GraduatedLocalizedDTO> graduatedLocalizedDTO = new ArrayList<>();
        for (Graduated grad : graduated) {
            graduatedLocalizedDTO.add(mapper.toGetDTO(grad).getLocalizationDto(lang));
        }
        return graduatedLocalizedDTO;
    }
}
