package uz.darkor.darkor_22.service.course.course;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.darkor.darkor_22.criteria.course.CourseCriteria;
import uz.darkor.darkor_22.dto.course.course.CourseCreateDTO;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;
import uz.darkor.darkor_22.dto.course.course.CourseUpdateDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;
import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.entity.system.Gallery;
import uz.darkor.darkor_22.exception.NotFoundException;
import uz.darkor.darkor_22.mapper.course.CourseMapper;
import uz.darkor.darkor_22.mapper.system.file.FileMapper;
import uz.darkor.darkor_22.repository.course.CourseRepository;
import uz.darkor.darkor_22.repository.system.file.FileRepository;
import uz.darkor.darkor_22.service.AbstractService;
import uz.darkor.darkor_22.utils.BaseUtils;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class CourseServiceImpl extends AbstractService<CourseMapper, CourseRepository> implements CourseService {
    private final FileRepository fileRepository;
    private final FileMapper fileMapper;
    public CourseServiceImpl(CourseMapper mapper, CourseRepository repository, FileRepository fileRepository, FileMapper fileMapper) {
        super(mapper, repository);
        this.fileRepository = fileRepository;
        this.fileMapper = fileMapper;
    }

    @Override
    public CourseGetDTO create(CourseCreateDTO DTO) {
//        Course course = mapper.fromCreateDTO(DTO);

        Course course = new Course(
                DTO.getNameUz(),
                DTO.getNameRu(),
                DTO.getNameEn(),
                DTO.getDescriptionUz(),
                DTO.getDescriptionEn(),
                DTO.getDescriptionRu()
        );

        List<Gallery> imageUz = new ArrayList<>();
        List<Gallery> imageRu = new ArrayList<>();
        List<Gallery> imageEn = new ArrayList<>();

        for (FileDTO fileDTO : DTO.getImageUz()) {
            Optional<Gallery> byId = fileRepository.findById(fileDTO.getId());
            imageUz.add(byId.get());
        }

        for (FileDTO fileDTO : DTO.getImageEn()) {
            Optional<Gallery> byId = fileRepository.findById(fileDTO.getId());
            imageRu.add(byId.get());
        }

        for (FileDTO fileDTO : DTO.getImageRu()) {
            Optional<Gallery> byId = fileRepository.findById(fileDTO.getId());
            imageEn.add(byId.get());
        }

        course.setImageUz(imageUz);
        course.setImageRu(imageRu);
        course.setImageEn(imageEn);

        Course save = repository.save(course);
        CourseGetDTO uz = save.getLocalizationDto("uz");
        return uz;

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
        return repository.findByCode(key).getLocalizationDto(BaseUtils.getSessionLang());
    }

    @Override
    public List<CourseGetDTO> list(CourseCriteria criteria) {
        List<CourseGetDTO> courseGetDTOS = new ArrayList<>();
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        List<Course> courses = repository.findAll(request).stream().toList();
        for (Course c : courses) {
            courseGetDTOS.add(c.getLocalizationDto(BaseUtils.getSessionLang()));
        }
        return courseGetDTOS;
    }
}
