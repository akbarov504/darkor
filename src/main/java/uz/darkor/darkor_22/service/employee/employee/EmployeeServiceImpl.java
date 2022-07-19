package uz.darkor.darkor_22.service.employee.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.darkor.darkor_22.criteria.employee.EmployeeCriteria;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeCreateDTO;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeGetDTO;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeUpdateDTO;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;
import uz.darkor.darkor_22.entity.auth.Employee;
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
    public EmployeeGetDTO create(EmployeeCreateDTO DTO) {
        Employee employee = fromCreateDTO(DTO);
        Employee save = repository.save(employee);
        return save.getLocalizationDto();
    }



    @Override
    public EmployeeGetDTO update(EmployeeUpdateDTO DTO) {
        Employee target = checkExistenceAndGetByCode(DTO.getCode());
        Employee employee = mapper.fromUpdateDTO(DTO, target);
        return repository.save(employee).getLocalizationDto();
    }

    @Override
    @Transactional
    public Boolean delete(UUID key) {
        Employee employee = checkExistenceAndGetByCode(key);
        repository.delete(employee);
        return Boolean.TRUE;
    }

    @Override
    public EmployeeGetDTO get(UUID key, String language) {
        return checkExistenceAndGetByCode(key).getLocalizationDto();
    }

    @Override
    public List<EmployeeGetDTO> list(EmployeeCriteria criteria, String language) {
        Pageable pageable = PageRequest.of(criteria.getPage(), criteria.getSize());
        List<Employee> employees = repository.findAll(pageable).getContent();
        return getLocalizedDtos(employees);
    }


    public List<EmployeeGetDTO> getAllByCourseCode(EmployeeCriteria criteria, UUID courseCode) {
        Course course = courseRepository.findByCode(courseCode);
        if (Objects.isNull(course)) throw new NotFoundException("COURSE_NOT_FOUND");
        Pageable pageable = PageRequest.of(criteria.getPage(), criteria.getSize());
        List<Employee> list = repository.findAllByCoursesAndType(List.of(course),EmployeeType.EXPERT);
        Page<Employee> employees = new PageImpl<>(list, pageable, repository.count());
        return getLocalizedDtos(employees.getContent());
    }

    public List<EmployeeGetDTO> getAll() {
        List<Employee> employees = repository.findAll();
        return getLocalizedDtos(employees);
    }

    private List<Course> getCourses(List<CourseGetDTO> DTOs) {
        List<Course> courses = new ArrayList<>();
        for (CourseGetDTO course : DTOs) {
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

    private List<EmployeeGetDTO> getLocalizedDtos(List<Employee> employees) {
        List<EmployeeGetDTO> employeeDtos = new ArrayList<>();
        for (Employee e : employees) {
            employeeDtos.add(e.getLocalizationDto());
        }
        return employeeDtos;
    }

    public Employee checkExistenceAndGetByCode(UUID code) {
        return repository.findByCode(code)
                .orElseThrow(() -> new NotFoundException("EMPLOYEE_NOT_FOUND"));

    }

}
