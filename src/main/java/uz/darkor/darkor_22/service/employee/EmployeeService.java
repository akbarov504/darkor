package uz.darkor.darkor_22.service.employee;

import uz.darkor.darkor_22.criteria.employee.EmployeeCriteria;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeCreateDTO;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeGetDTO;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeUpdateDTO;
import uz.darkor.darkor_22.service.BaseService;
import uz.darkor.darkor_22.service.GenericCUDService;
import uz.darkor.darkor_22.service.GenericGLService;

import java.util.UUID;

public interface EmployeeService extends GenericCUDService<EmployeeCreateDTO, EmployeeUpdateDTO, EmployeeGetDTO, UUID>,
        GenericGLService<EmployeeGetDTO, EmployeeCriteria, UUID>, BaseService {
}
