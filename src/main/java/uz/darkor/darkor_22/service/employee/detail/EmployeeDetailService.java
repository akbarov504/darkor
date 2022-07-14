package uz.darkor.darkor_22.service.employee.detail;

import org.springframework.stereotype.Service;
import uz.darkor.darkor_22.criteria.BaseCriteria;
import uz.darkor.darkor_22.dto.auth.employee_detail.EmployeeDetailCreateDTO;
import uz.darkor.darkor_22.dto.auth.employee_detail.EmployeeDetailGetDTO;
import uz.darkor.darkor_22.dto.auth.employee_detail.EmployeeDetailUpdateDTO;
import uz.darkor.darkor_22.service.BaseService;
import uz.darkor.darkor_22.service.GenericCUDService;
import uz.darkor.darkor_22.service.GenericGLService;

import java.util.UUID;

@Service
public interface EmployeeDetailService
        extends GenericCUDService<EmployeeDetailCreateDTO, EmployeeDetailUpdateDTO, EmployeeDetailGetDTO, UUID>,
        GenericGLService<EmployeeDetailGetDTO, BaseCriteria, UUID>, BaseService {

    EmployeeDetailGetDTO getAllByEmployee(UUID employeeCode);
}
