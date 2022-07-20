package uz.darkor.darkor_22.controller.employee;

import uz.darkor.darkor_22.controller.GenericCUDController;
import uz.darkor.darkor_22.controller.GenericGLController;
import uz.darkor.darkor_22.criteria.employee.EmployeeCriteria;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeCreateDTO;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeGetDTO;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeLocalizedDTO;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeUpdateDTO;

import java.util.UUID;

public interface EmployeeController
        extends GenericCUDController<EmployeeCreateDTO, EmployeeUpdateDTO, EmployeeLocalizedDTO, UUID>,
        GenericGLController<EmployeeLocalizedDTO, EmployeeCriteria, UUID> {
}
