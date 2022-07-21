package uz.darkor.darkor_22.service.employee.employee;

import uz.darkor.darkor_22.criteria.employee.EmployeeCriteria;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeCreateDTO;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeGetDTO;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeLocalizedDTO;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeUpdateDTO;
import uz.darkor.darkor_22.entity.employee.Employee;
import uz.darkor.darkor_22.service.BaseService;
import uz.darkor.darkor_22.service.GenericCUDService;
import uz.darkor.darkor_22.service.GenericGLService;

import java.util.List;
import java.util.UUID;

public interface EmployeeService extends GenericCUDService<EmployeeCreateDTO, EmployeeUpdateDTO, EmployeeLocalizedDTO, UUID>,
        GenericGLService<EmployeeLocalizedDTO, EmployeeCriteria, UUID>, BaseService {

    Employee checkExistenceAndGetByCode(UUID id);

    List<EmployeeLocalizedDTO> getAllByCourseCode(EmployeeCriteria criteria, UUID courseCode);
}
