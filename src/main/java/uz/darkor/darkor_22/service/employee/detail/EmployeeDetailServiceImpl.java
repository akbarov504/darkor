package uz.darkor.darkor_22.service.employee.detail;

import org.springframework.stereotype.Service;
import uz.darkor.darkor_22.criteria.BaseCriteria;
import uz.darkor.darkor_22.dto.auth.employee_detail.EmployeeDetailCreateDTO;
import uz.darkor.darkor_22.dto.auth.employee_detail.EmployeeDetailGetDTO;
import uz.darkor.darkor_22.dto.auth.employee_detail.EmployeeDetailUpdateDTO;
import uz.darkor.darkor_22.entity.auth.Employee;
import uz.darkor.darkor_22.entity.auth.EmployeeDetail;
import uz.darkor.darkor_22.exception.NotFoundException;
import uz.darkor.darkor_22.mapper.employee.EmployeeDetailMapper;
import uz.darkor.darkor_22.repository.employee.EmployeeDetailRepository;
import uz.darkor.darkor_22.service.AbstractService;
import uz.darkor.darkor_22.service.employee.employee.EmployeeService;
import uz.darkor.darkor_22.service.employee.employee.EmployeeServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeDetailServiceImpl extends AbstractService<EmployeeDetailMapper, EmployeeDetailRepository>
        implements EmployeeDetailService {

    private final EmployeeService employeeService;

    public EmployeeDetailServiceImpl(EmployeeDetailMapper mapper,
                                     EmployeeDetailRepository repository,
                                     EmployeeServiceImpl employeeService) {
        super(mapper, repository);
        this.employeeService = employeeService;
    }

    @Override
    public EmployeeDetailGetDTO create(EmployeeDetailCreateDTO DTO) {
        EmployeeDetail employeeDetail = mapper.fromCreateDTO(DTO);
        return repository.save(employeeDetail).getLocalizationDto();
    }

    @Override
    public EmployeeDetailGetDTO update(EmployeeDetailUpdateDTO DTO) {
        EmployeeDetail target = checkUserDetailsExistenceAndGetByCode(DTO.getCode());
        EmployeeDetail employeeDetail = mapper.fromUpdateDTO(DTO, target);
        return repository.save(employeeDetail).getLocalizationDto();
    }

    @Override
    public Boolean delete(UUID key) {
        return repository.deleteByCode(key);
    }

    @Override
    public EmployeeDetailGetDTO get(UUID key, String language) {
        EmployeeDetail employeeDetail = checkUserDetailsExistenceAndGetByCode(key);
        return employeeDetail.getLocalizationDto();
    }

    @Override
    public List<EmployeeDetailGetDTO> list(BaseCriteria criteria, String language) {
        List<EmployeeDetail> employeeDetails = repository.findAll();
        return getLocalizedDtos(employeeDetails);
    }

    public EmployeeDetailGetDTO getAllByEmployee(UUID employeeCode) {
        Employee employee = employeeService.checkExistenceAndGetByCode(employeeCode);
        EmployeeDetail employeeDetail = repository.findByEmployee(employee)
                .orElseThrow(() -> new NotFoundException("EMPLOYEE_DETAIL_NOT_FOUND"));
        return employeeDetail.getLocalizationDto();
    }


    private List<EmployeeDetailGetDTO> getLocalizedDtos(List<EmployeeDetail> employeeDetails) {
        List<EmployeeDetailGetDTO> employeeDetailGetDTOs = new ArrayList<>();
        for (EmployeeDetail ed : employeeDetails) {
            employeeDetailGetDTOs.add(ed.getLocalizationDto());
        }
        return employeeDetailGetDTOs;
    }

    private EmployeeDetail checkUserDetailsExistenceAndGetByCode(UUID code) {
        return repository.findByCode(code)
                .orElseThrow(() -> new NotFoundException("EMPLOYEE_DETAIL_NOT_FOUND"));
    }


}
