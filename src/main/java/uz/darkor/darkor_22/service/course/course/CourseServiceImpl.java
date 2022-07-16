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

    public CourseServiceImpl(CourseMapper mapper,
                             CourseRepository repository,
                             FileRepository fileRepository,
                             FileMapper fileMapper) {
        super(mapper, repository);
        this.fileRepository = fileRepository;
        this.fileMapper = fileMapper;
    }

    @Override
    public CourseGetDTO create(CourseCreateDTO DTO) {
        Course course = fromCreatDto(DTO);
        Course save = repository.save(course);
        CourseGetDTO uz = save.getLocalizationDto("uz");
        return uz;

    }

    @Override
    public CourseGetDTO update(CourseUpdateDTO DTO) {
        Optional<Course> courseOptional = repository.findById(DTO.getId());
        Course course = courseOptional.get();
        if (Objects.isNull(course)) {
            throw new NotFoundException("Course not found");
        }

         course = fromUpdateDto(DTO);

        System.out.println(mapper.fromUpdateDTO(DTO, course));
        return repository.save(course).getLocalizationDto("uz");
    }

    @Override
    public Boolean delete(UUID key) {
        return repository.deleteByCode(key);
    }

    @Override
    public CourseGetDTO get(UUID key, String language) {
        return repository.findByCode(key).getLocalizationDto(BaseUtils.getSessionLang());
    }

    @Override
    public List<CourseGetDTO> list(CourseCriteria criteria, String language) {
        List<CourseGetDTO> courseGetDTOS = new ArrayList<>();
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        List<Course> courses = repository.findAll(request).stream().toList();
        for (Course c : courses) {
            courseGetDTOS.add(c.getLocalizationDto(BaseUtils.getSessionLang()));
        }
        return courseGetDTOS;
    }

    private Course fromCreatDto(CourseCreateDTO DTO) {
        return new Course(
                DTO.getNameUz(),
                DTO.getNameRu(),
                DTO.getNameEn(),
                DTO.getDescriptionUz(),
                DTO.getDescriptionEn(),
                DTO.getDescriptionRu(),
                processGallery(DTO.getImageUz()),
                processGallery(DTO.getImageRu()),
                processGallery(DTO.getImageEn())
        );
    }

    private Course fromUpdateDto(CourseUpdateDTO DTO) {
        return new Course(
                DTO.getNameUz(),
                DTO.getNameRu(),
                DTO.getNameEn(),
                DTO.getDescriptionUz(),
                DTO.getDescriptionEn(),
                DTO.getDescriptionRu(),
                processGallery(DTO.getImageUz()),
                processGallery(DTO.getImageRu()),
                processGallery(DTO.getImageEn())
        );
    }

    private List<Gallery> processGallery(List<FileDTO> fileDTOS) {
        List<Gallery> galleries = new ArrayList<>();
        for (FileDTO fileDTO : fileDTOS) {
            Optional<Gallery> gallery = fileRepository.findById(fileDTO.getId());
            galleries.add(gallery.get());
        }
        return galleries;
    }

    public CourseUpdateDTO getForUpdate(Long id) {
        Optional<Course> byId = repository.findById(id);
        if (byId.isEmpty()) throw new NotFoundException("Course not found");
        return mapper.toUpdateDTO(byId.get());
    }
}
