package uz.darkor.darkor_22.service.employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.darkor.darkor_22.criteria.employee.EmployeeCriteria;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeCreateDTO;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeGetDTO;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeUpdateDTO;
import uz.darkor.darkor_22.entity.auth.Employee;
import uz.darkor.darkor_22.entity.auth.EmployeeDetail;
import uz.darkor.darkor_22.mapper.employee.EmployeeMapper;
import uz.darkor.darkor_22.repository.employee.EmployeeRepository;
import uz.darkor.darkor_22.service.AbstractService;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl extends AbstractService<EmployeeMapper, EmployeeRepository>
        implements EmployeeService {

    public EmployeeServiceImpl(EmployeeMapper mapper,
                               EmployeeRepository repository) {
        super(mapper, repository);
    }

    @Override
    public EmployeeGetDTO create(EmployeeCreateDTO DTO) {
        Employee employee = mapper.fromCreateDTO(DTO);
        return repository.save(employee).getLocalizationDto("");
    }

    @Override
    public EmployeeGetDTO update(EmployeeUpdateDTO DTO) {
        return null;
    }

    @Override
    public Boolean delete(UUID key) {
        return null;
    }

    @Override
    public EmployeeGetDTO get(UUID key) {
        return null;
    }

    @Override
    public List<EmployeeGetDTO> list(EmployeeCriteria criteria) {
        return null;
    }

}
