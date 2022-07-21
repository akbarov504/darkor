package uz.darkor.darkor_22.service.course.skill;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.darkor.darkor_22.criteria.skill.SkillCriteria;
import uz.darkor.darkor_22.dto.course.skill.SkillCreateDTO;
import uz.darkor.darkor_22.dto.course.skill.SkillLocalizedDTO;
import uz.darkor.darkor_22.dto.course.skill.SkillUpdateDTO;
import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.entity.course.Skill;
import uz.darkor.darkor_22.exception.NotFoundException;
import uz.darkor.darkor_22.mapper.skill.SkillMapper;
import uz.darkor.darkor_22.repository.course.CourseRepository;
import uz.darkor.darkor_22.repository.skill.SkillRepository;
import uz.darkor.darkor_22.service.AbstractService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class SkillServiceImpl extends AbstractService<SkillMapper, SkillRepository>
        implements SkillService {

    private final CourseRepository courseRepository;

    public SkillServiceImpl(SkillMapper mapper,
                            SkillRepository repository,
                            CourseRepository courseRepository) {
        super(mapper, repository);
        this.courseRepository = courseRepository;
    }

    @Override
    public SkillLocalizedDTO create(SkillCreateDTO DTO) {
        Skill skill = mapper.fromCreateDTO(DTO);
        Skill save = repository.save(skill);
        return mapper.toGetDTO(save).getLocalizationDto("uz");
    }

    @Override
    public SkillLocalizedDTO update(SkillUpdateDTO DTO) {
        Skill target = checkExistenceAndGetById(DTO.getCode());
        Skill skill = mapper.fromUpdateDTO(DTO, target);
        Skill updateSkill = repository.save(skill);
        return mapper.toGetDTO(updateSkill).getLocalizationDto("uz");
    }

    @Override
    public Boolean delete(UUID key) {
        try {
            Skill skill = repository.findByCode(key).orElseThrow(() -> {
                throw new NotFoundException("Skill not found !");
            });
            skill.setDeleted(true);
            repository.save(skill);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public SkillLocalizedDTO get(UUID key, String language) {
        Skill skill = checkExistenceAndGetById(key);
        return mapper.toGetDTO(skill).getLocalizationDto(language);
    }

    @Override
    public List<SkillLocalizedDTO> list(SkillCriteria criteria, String language) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        List<Skill> skills = repository.findAll(request).getContent();
        return getLocalizedDTOs(skills, language);
    }

    @Override
    public List<SkillLocalizedDTO> getByCourseCode(UUID code, String lang) {
        Course course = courseRepository.findByCode(code);
        if (Objects.isNull(course))
            throw new NotFoundException("COURSE_NOT_FOUND");
        List<Skill> skills = repository.findByCourse(course);
        return getLocalizedDTOs(skills, lang);
    }

    private List<SkillLocalizedDTO> getLocalizedDTOs(List<Skill> skills, String lang) {
        List<SkillLocalizedDTO> SkillLocalizedDTOS = new ArrayList<>();
        for (Skill skill : skills) {
            SkillLocalizedDTOS.add(mapper.toGetDTO(skill).getLocalizationDto(lang));
        }
        return SkillLocalizedDTOS;
    }

    private Skill checkExistenceAndGetById(UUID code) {
        return repository.findByCode(code)
                .orElseThrow(() -> new NotFoundException("SKILL_NOT_FOUND"));
    }
}
