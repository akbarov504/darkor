package uz.darkor.darkor_22.service.employee.detail;

import org.springframework.stereotype.Service;
import uz.darkor.darkor_22.criteria.BaseCriteria;
import uz.darkor.darkor_22.dto.auth.employee_detail.EmployeeDetailCreateDTO;
import uz.darkor.darkor_22.dto.auth.employee_detail.EmployeeDetailGetDTO;
import uz.darkor.darkor_22.dto.auth.employee_detail.EmployeeDetailLocalizedDTO;
import uz.darkor.darkor_22.dto.auth.employee_detail.EmployeeDetailUpdateDTO;
import uz.darkor.darkor_22.dto.course.course.CourseLocalizationDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;
import uz.darkor.darkor_22.entity.auth.Employee;
import uz.darkor.darkor_22.entity.auth.EmployeeDetail;
import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.entity.system.Gallery;
import uz.darkor.darkor_22.exception.NotFoundException;
import uz.darkor.darkor_22.mapper.employee.EmployeeDetailMapper;
import uz.darkor.darkor_22.repository.course.CourseRepository;
import uz.darkor.darkor_22.repository.employee.EmployeeDetailRepository;
import uz.darkor.darkor_22.repository.system.file.FileRepository;
import uz.darkor.darkor_22.service.AbstractService;
import uz.darkor.darkor_22.service.employee.employee.EmployeeService;
import uz.darkor.darkor_22.service.employee.employee.EmployeeServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeDetailServiceImpl extends AbstractService<EmployeeDetailMapper, EmployeeDetailRepository>
        implements EmployeeDetailService {

    private final EmployeeService employeeService;
    private final CourseRepository courseRepository;
    private final FileRepository fileRepository;

    public EmployeeDetailServiceImpl(EmployeeDetailMapper mapper,
                                     EmployeeDetailRepository repository,
                                     EmployeeServiceImpl employeeService,
                                     CourseRepository courseRepository,
                                     FileRepository fileRepository) {
        super(mapper, repository);
        this.employeeService = employeeService;
        this.courseRepository = courseRepository;
        this.fileRepository = fileRepository;
    }

    @Override
    public EmployeeDetailLocalizedDTO create(EmployeeDetailCreateDTO DTO) {
        EmployeeDetail employeeDetail = fromCreateDTO(DTO);
        EmployeeDetail save = repository.save(employeeDetail);
        return mapper.toGetDTO(save).getLocalizationDto();
    }

    @Override
    public EmployeeDetailLocalizedDTO update(EmployeeDetailUpdateDTO DTO) {
        EmployeeDetail target = checkUserDetailsExistenceAndGetByCode(DTO.getCode());
        EmployeeDetail employeeDetail = mapper.fromUpdateDTO(DTO, target);
        EmployeeDetail save = repository.save(employeeDetail);
        return mapper.toGetDTO(save).getLocalizationDto();
    }

    @Override
    public Boolean delete(UUID key) {
        return repository.deleteByCode(key);
    }

    @Override
    public EmployeeDetailLocalizedDTO get(UUID key, String language) {
        EmployeeDetail employeeDetail = checkUserDetailsExistenceAndGetByCode(key);
        return mapper.toGetDTO(employeeDetail).getLocalizationDto();
    }

    @Override
    public List<EmployeeDetailLocalizedDTO> list(BaseCriteria criteria, String language) {
        List<EmployeeDetail> employeeDetails = repository.findAll();
        return getLocalizedDtos(employeeDetails);
    }

    public EmployeeDetailLocalizedDTO getAllByEmployee(UUID employeeCode) {
        Employee employee = employeeService.checkExistenceAndGetByCode(employeeCode);
        EmployeeDetail employeeDetail = repository.findByEmployee(employee)
                .orElseThrow(() -> new NotFoundException("EMPLOYEE_DETAIL_NOT_FOUND"));
        return mapper.toGetDTO(employeeDetail).getLocalizationDto();
    }


    private List<EmployeeDetailLocalizedDTO> getLocalizedDtos(List<EmployeeDetail> employeeDetails) {
        List<EmployeeDetailLocalizedDTO> employeeDetailLocalizedDTOS = new ArrayList<>();
        List<EmployeeDetailGetDTO> employeeDetailGetDTOS = mapper.toListDTO(employeeDetails);
        for (EmployeeDetailGetDTO dto : employeeDetailGetDTOS) {
            employeeDetailLocalizedDTOS.add(dto.getLocalizationDto());
        }
        return employeeDetailLocalizedDTOS;
    }

    private EmployeeDetail fromCreateDTO(EmployeeDetailCreateDTO dto) {
        return new EmployeeDetail(dto.getTitleDescriptionUz(),
                dto.getTitleDescriptionRu(),
                dto.getTitleDescriptionEn(),
                dto.getBodyDescriptionUz(),
                dto.getBodyDescriptionRu(),
                dto.getBodyDescriptionEn(),
                getCourses(dto.getEmployee().getCourses()),
                processGallery(dto.getGalleries()),
                employeeService.checkExistenceAndGetByCode(dto.getEmployee().getCode()));
    }

    private List<Gallery> processGallery(List<FileDTO> fileDTOS) {
        List<Gallery> galleries = new ArrayList<>();
        for (FileDTO fileDTO : fileDTOS) {
            Optional<Gallery> gallery = fileRepository.findById(fileDTO.getId());
            galleries.add(gallery.get());
        }
        return galleries;
    }

    private List<Course> getCourses(List<CourseLocalizationDTO> DTOs) {
        List<Course> courses = new ArrayList<>();
        for (CourseLocalizationDTO course : DTOs) {
            Course byCode = courseRepository.findById(course.getId()).orElseThrow(() -> new NotFoundException("Coures not found"));
            courses.add(byCode);
        }
        return courses;
    }

    private EmployeeDetail checkUserDetailsExistenceAndGetByCode(UUID code) {
        return repository.findByCode(code)
                .orElseThrow(() -> new NotFoundException("EMPLOYEE_DETAIL_NOT_FOUND"));
    }


}
