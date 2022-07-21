package uz.darkor.darkor_22.service.employee.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.darkor.darkor_22.criteria.employee.EmployeeCriteria;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeCreateDTO;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeLocalizedDTO;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeUpdateDTO;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;
import uz.darkor.darkor_22.dto.course.course.CourseLocalizationDTO;
import uz.darkor.darkor_22.entity.employee.Employee;
import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.enums.EmployeeType;
import uz.darkor.darkor_22.exception.NotFoundException;
import uz.darkor.darkor_22.mapper.employee.EmployeeMapper;
import uz.darkor.darkor_22.repository.course.CourseRepository;
import uz.darkor.darkor_22.repository.employee.EmployeeRepository;
import uz.darkor.darkor_22.repository.system.file.FileRepository;
import uz.darkor.darkor_22.service.AbstractService;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class EmployeeServiceImpl extends AbstractService<EmployeeMapper, EmployeeRepository>
        implements EmployeeService {

    private final FileRepository fileRepository;
    private final CourseRepository courseRepository;


    public EmployeeServiceImpl(EmployeeMapper mapper,
                               EmployeeRepository repository,
                               FileRepository fileRepository,
                               CourseRepository courseRepository) {
        super(mapper, repository);
        this.fileRepository = fileRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public EmployeeLocalizedDTO create(EmployeeCreateDTO DTO) {
        Employee employee = fromCreateDTO(DTO);
        Employee save = repository.save(employee);
        return mapper.toGetDTO(save).getLocalizationDto();
    }


    @Override
    public EmployeeLocalizedDTO update(EmployeeUpdateDTO DTO) {
        Employee target = checkExistenceAndGetByCode(DTO.getCode());
        Employee employee = mapper.fromUpdateDTO(DTO, target);
        Employee updatedEmployee = repository.save(employee);
        return mapper.toGetDTO(updatedEmployee).getLocalizationDto();
    }

    @Override
    @Transactional
    public Boolean delete(UUID key) {
        Employee employee = checkExistenceAndGetByCode(key);
        repository.delete(employee);
        return Boolean.TRUE;
    }

    @Override
    public EmployeeLocalizedDTO get(UUID key, String language) {
        Employee employee = checkExistenceAndGetByCode(key);
        return mapper.toGetDTO(employee).getLocalizationDto();
    }

    @Override
    public List<EmployeeLocalizedDTO> list(EmployeeCriteria criteria, String language) {
        Pageable pageable = PageRequest.of(criteria.getPage(), criteria.getSize());
        List<Employee> employees = repository.findAll(pageable).getContent();
        return getLocalizedDtos(employees);
    }


    public List<EmployeeLocalizedDTO> getAllByCourseCode(EmployeeCriteria criteria, UUID courseCode) {
        Course course = courseRepository.findByCode(courseCode);
        if (Objects.isNull(course)) throw new NotFoundException("COURSE_NOT_FOUND");
        Pageable pageable = PageRequest.of(criteria.getPage(), criteria.getSize());
        List<Employee> list = repository.findAllByCourses(course.getId());
        Page<Employee> employees = new PageImpl<>(list, pageable, repository.count());
        return getLocalizedDtos(employees.getContent());
    }

    public List<EmployeeLocalizedDTO> getAll() {
        List<Employee> employees = repository.findAll();
        return getLocalizedDtos(employees);
    }

    private List<Course> getCourses(List<CourseLocalizationDTO> DTOs) {
        List<Course> courses = new ArrayList<>();
        for (CourseLocalizationDTO course : DTOs) {
            Course byCode = courseRepository.findById(course.getId()).orElseThrow(() -> new NotFoundException("Coures not found"));
            courses.add(byCode);
        }
        return courses;
    }


    private Employee fromCreateDTO(EmployeeCreateDTO DTO) {
        return new Employee(DTO.getFullNameUz(),
                DTO.getFullNameRu(),
                DTO.getFullNameEn(),
                EmployeeType.valueOf(DTO.getType()),
                fileRepository.findAllByCode(DTO.getGallery().getCode())
                        .orElseThrow(() -> new NotFoundException("GALLERY_NOT_FOUND")),
                getCourses(DTO.getCourses())
        );
    }

    private List<EmployeeLocalizedDTO> getLocalizedDtos(List<Employee> employees) {
        List<EmployeeLocalizedDTO> employeeDtos = new ArrayList<>();
        for (Employee e : employees) {
            employeeDtos.add(mapper.toGetDTO(e).getLocalizationDto());
        }
        return employeeDtos;
    }


    public Employee checkExistenceAndGetByCode(UUID code) {
        return repository.findByCode(code)
                .orElseThrow(() -> new NotFoundException("EMPLOYEE_NOT_FOUND"));

    }

}
