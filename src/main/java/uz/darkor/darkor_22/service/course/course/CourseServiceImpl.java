package uz.darkor.darkor_22.service.course.course;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.darkor.darkor_22.criteria.course.CourseCriteria;
import uz.darkor.darkor_22.dto.course.course.CourseCreateDTO;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;
import uz.darkor.darkor_22.dto.course.course.CourseUpdateDTO;
import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.exception.NotFoundException;
import uz.darkor.darkor_22.mapper.course.CourseMapper;
import uz.darkor.darkor_22.repository.course.CourseRepository;
import uz.darkor.darkor_22.service.AbstractService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@Transactional
public class CourseServiceImpl extends AbstractService<CourseMapper, CourseRepository> implements CourseService {
    public CourseServiceImpl(CourseMapper mapper, CourseRepository repository) {
        super(mapper, repository);
    }

    @Override
    public CourseGetDTO create(CourseCreateDTO DTO) {
        return repository.save(mapper.toCreateDTO(DTO)).getLocalizationDto("");
    }

    @Override
    public CourseGetDTO update(CourseUpdateDTO DTO) {
        Course course = repository.findByCode(DTO.getCode());
        if (Objects.isNull(course)) {
            throw new NotFoundException("Course not found");
        }
        course.setNameUz(DTO.getNameUz());
        course.setNameRu(DTO.getNameRu());
        course.setNameEn(DTO.getNameEn());

        course.setDescriptionUz(DTO.getDescriptionUz());
        course.setDescriptionRu(DTO.getDescriptionRu());
        course.setDescriptionEn(DTO.getDescriptionEn());

        course.setImageUz(DTO.getImageUz());
        course.setImageRu(DTO.getImageRu());
        course.setImageEn(DTO.getImageEn());
        return repository.save(course).getLocalizationDto("");
    }

    @Override
    public Boolean delete(UUID key) {
        return repository.deleteByCode(key);
    }

    @Override
    public CourseGetDTO get(UUID key) {
        return repository.findByCode(key).getLocalizationDto("");
    }

    @Override
    public List<CourseGetDTO> list(CourseCriteria criteria) {
        List<CourseGetDTO> courseGetDTOS = new ArrayList<>();
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        List<Course> courses = repository.findAll(request).stream().toList();
        for (Course c : courses) {
            courseGetDTOS.add(c.getLocalizationDto(""));
        }
        return courseGetDTOS;
    }
}
