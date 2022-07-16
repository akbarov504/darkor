package uz.darkor.darkor_22.service.course.skill;

import org.springframework.stereotype.Service;
import uz.darkor.darkor_22.criteria.BaseCriteria;
import uz.darkor.darkor_22.dto.course.skill.SkillCreateDTO;
import uz.darkor.darkor_22.dto.course.skill.SkillGetDTO;
import uz.darkor.darkor_22.dto.course.skill.SkillUpdateDTO;
import uz.darkor.darkor_22.entity.auth.EmployeeDetail;
import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.entity.course.Skill;
import uz.darkor.darkor_22.exception.NotFoundException;
import uz.darkor.darkor_22.mapper.skill.SkillMapper;
import uz.darkor.darkor_22.repository.course.CourseRepository;
import uz.darkor.darkor_22.repository.employee.EmployeeDetailRepository;
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
    private final EmployeeDetailRepository employeeDetailRepository;

    public SkillServiceImpl(SkillMapper mapper,
                            SkillRepository repository,
                            CourseRepository courseRepository,
                            EmployeeDetailRepository employeeDetailRepository) {
        super(mapper, repository);
        this.courseRepository = courseRepository;
        this.employeeDetailRepository = employeeDetailRepository;
    }

    @Override
    public SkillGetDTO create(SkillCreateDTO DTO) {
        Skill skill = mapper.fromCreateDTO(DTO);
        Skill newSkill = repository.save(skill);
        return mapper.toGetDTO(newSkill);
    }

    @Override
    public SkillGetDTO update(SkillUpdateDTO DTO) {
        Skill target = checkExistenceAndGetById(DTO.getCode());
        Skill skill = mapper.fromUpdateDTO(DTO, target);
        Skill updateSkill = repository.save(skill);
        return updateSkill.getLocalizationDto();
    }

    @Override
    public Boolean delete(UUID key) {
        return repository.deleteByCode(key);
    }

    @Override
    public SkillGetDTO get(UUID key, String language) {
        Skill skill = checkExistenceAndGetById(key);
        return skill.getLocalizationDto();
    }

    @Override
    public List<SkillGetDTO> list(BaseCriteria criteria, String language) {
        List<Skill> skills = repository.findAll();
        return getLocalizedDTOs(skills);
    }

    @Override
    public List<SkillGetDTO> getByCourseCode(UUID code) {
        Course course = courseRepository.findByCode(code);
        if (Objects.isNull(course))
            throw new NotFoundException("COURSE_NOT_FOUND");
        List<Skill> skills = repository.findByCourse(course);
        return getLocalizedDTOs(skills);
    }

    @Override
    public List<SkillGetDTO> getByEmployeeDetail(UUID code) {
        EmployeeDetail employeeDetail = employeeDetailRepository.findByCode(code)
                .orElseThrow(() -> new NotFoundException("EMPLOYEE_DETAIL_NOT_FOUND"));
        List<Skill> skills = repository.findByEmployeeDetails(employeeDetail);
        return getLocalizedDTOs(skills);
    }

    private List<SkillGetDTO> getLocalizedDTOs(List<Skill> skills) {
        List<SkillGetDTO> skillGetDTOS = new ArrayList<>();
        for (Skill skill : skills) {
            skillGetDTOS.add(skill.getLocalizationDto());
        }
        return skillGetDTOS;
    }

    private Skill checkExistenceAndGetById(UUID code) {
        return repository.findByCode(code)
                .orElseThrow(() -> new NotFoundException("SKILL_NOT_FOUND"));
    }
}
