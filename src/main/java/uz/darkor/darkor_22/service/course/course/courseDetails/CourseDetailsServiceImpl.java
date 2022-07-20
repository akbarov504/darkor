package uz.darkor.darkor_22.service.course.course.courseDetails;

import org.springframework.stereotype.Service;
import uz.darkor.darkor_22.criteria.course.CourseDetailCriteria;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeGetDTO;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;
import uz.darkor.darkor_22.dto.course.course_detail.CourseDetailCreateDTO;
import uz.darkor.darkor_22.dto.course.course_detail.CourseDetailLocalizationDTO;
import uz.darkor.darkor_22.dto.course.course_detail.CourseDetailUpdateDTO;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;
import uz.darkor.darkor_22.entity.auth.Employee;
import uz.darkor.darkor_22.entity.course.CourseDetail;
import uz.darkor.darkor_22.entity.course.Price;
import uz.darkor.darkor_22.entity.system.Gallery;
import uz.darkor.darkor_22.exception.NotFoundException;
import uz.darkor.darkor_22.mapper.course.CourseDetailsMapper;
import uz.darkor.darkor_22.mapper.price.PriceMapper;
import uz.darkor.darkor_22.repository.course.detail.CourseDetailRepository;
import uz.darkor.darkor_22.repository.employee.EmployeeRepository;
import uz.darkor.darkor_22.repository.price.PriceRepository;
import uz.darkor.darkor_22.repository.system.file.FileRepository;
import uz.darkor.darkor_22.service.AbstractService;
import uz.darkor.darkor_22.service.course.course.CourseDetailsService;
import uz.darkor.darkor_22.service.course.course.CourseServiceImpl;
import uz.darkor.darkor_22.service.course.price.PriceServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseDetailsServiceImpl extends AbstractService<CourseDetailsMapper, CourseDetailRepository> implements CourseDetailsService {
    private final FileRepository fileRepository;
    private final EmployeeRepository employeeRepository;
    private final PriceRepository priceRepository;
    private final PriceMapper priceMapper;
    private final PriceServiceImpl priceService;
    private final CourseServiceImpl courseService;
    public CourseDetailsServiceImpl(CourseDetailsMapper mapper, CourseDetailRepository repository, FileRepository fileRepository, EmployeeRepository employeeRepository, PriceRepository priceRepository, PriceMapper priceMapper, PriceServiceImpl priceService, CourseServiceImpl courseService) {
        super(mapper, repository);
        this.fileRepository = fileRepository;
        this.employeeRepository = employeeRepository;
        this.priceRepository = priceRepository;
        this.priceMapper = priceMapper;
        this.priceService = priceService;
        this.courseService = courseService;
    }

    @Override
    public CourseDetailLocalizationDTO create(CourseDetailCreateDTO DTO) {
        CourseDetail courseDetail = mapper.fromCreateDTO(DTO);
        courseDetail.setFileUz(processGallery(DTO.getFileUz()));
        courseDetail.setFileRu(processGallery(DTO.getFileRu()));
        courseDetail.setFileEn(processGallery(DTO.getFileEn()));
        courseDetail.setPrice(priceService.createForEveryService(DTO.getPrice()));
        courseDetail.setCourse(courseService.createForEveryService(DTO.getCourse()));
        CourseDetail save = repository.save(courseDetail);
        return mapper.toGetDTO(save).getLocalizationDto("uz");
    }

    @Override
    public CourseDetailLocalizationDTO update(CourseDetailUpdateDTO DTO) {
        Optional<CourseDetail> byId = repository.findById(DTO.getId());
        if(byId.isEmpty()) throw new NotFoundException("Course Notfound");
        CourseDetail courseDetail = mapper.fromUpdateDTO(DTO, byId.get());
        courseDetail.setFileUz(processGallery(DTO.getFileUz()));
        courseDetail.setFileRu(processGallery(DTO.getFileRu()));
        courseDetail.setFileEn(processGallery(DTO.getFileEn()));
        Optional<Price> byId1 = priceRepository.findById(DTO.getPrice().getId());
        if (byId1.isEmpty()) throw new NotFoundException("Price not found");
        priceRepository.save(priceMapper.fromUpdateDTO(DTO.getPrice(), byId1.get()));
        courseDetail.setCourse(courseService.updateForEveryService(DTO.getCourse()));
        CourseDetail save = repository.save(courseDetail);
        return mapper.toGetDTO(save).getLocalizationDto("uz");
    }

    public CourseDetailUpdateDTO getForUpdate(Long id){
        Optional<CourseDetail> byId = repository.findById(id);
        if (byId.isEmpty()) throw new NotFoundException("Course Detail not found");
        return mapper.toUpdateDTO(byId.get());
    }

    @Override
    public Boolean delete(Long key) {
        try{
            repository.deleteById(key);
            return true;
        }catch (NotFoundException e){
            throw new NotFoundException("Notfound");
        }
    }

    public CourseDetailLocalizationDTO get(CourseGetDTO courseDto, String language) {
        CourseDetail byCourse = repository.findByCourseId(courseDto.getId());
        return mapper.toGetDTO(byCourse).getLocalizationDto(language);
    }

    @Override
    public CourseDetailLocalizationDTO get(Long key, String language) {
        return null;
    }

    @Override
    public List<CourseDetailLocalizationDTO> list(CourseDetailCriteria criteria, String language) {
        return null;
    }


    /* Yordamchi metodlar */

    private List<Gallery> processGallery(List<FileDTO> fileDTOS) {
        List<Gallery> galleries = new ArrayList<>();
        for (FileDTO fileDTO : fileDTOS) {
            Optional<Gallery> gallery = fileRepository.findById(fileDTO.getId());
            galleries.add(gallery.get());
        }
        return galleries;
    }

    private List<Employee> processEmployee(List<EmployeeGetDTO> employeesDTO) {
        List<Employee> employees = new ArrayList<>();
        for (EmployeeGetDTO employeeDto : employeesDTO) {
            Optional<Employee> skill = employeeRepository.findById(employeeDto.getId());
            employees.add(skill.get());
        }
        return employees;
    }

}
