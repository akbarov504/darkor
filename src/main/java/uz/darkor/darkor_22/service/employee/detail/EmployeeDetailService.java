package uz.darkor.darkor_22.service.employee.detail;

import uz.darkor.darkor_22.criteria.BaseCriteria;
import uz.darkor.darkor_22.dto.auth.employee_detail.EmployeeDetailCreateDTO;
import uz.darkor.darkor_22.dto.auth.employee_detail.EmployeeDetailLocalizedDTO;
import uz.darkor.darkor_22.dto.auth.employee_detail.EmployeeDetailUpdateDTO;
import uz.darkor.darkor_22.service.BaseService;
import uz.darkor.darkor_22.service.GenericCUDService;
import uz.darkor.darkor_22.service.GenericGLService;

import java.util.UUID;


public interface EmployeeDetailService
        extends GenericCUDService<EmployeeDetailCreateDTO, EmployeeDetailUpdateDTO, EmployeeDetailLocalizedDTO, UUID>,
        GenericGLService<EmployeeDetailLocalizedDTO, BaseCriteria, UUID>, BaseService {

    EmployeeDetailLocalizedDTO getAllByEmployee(UUID employeeCode);
}
