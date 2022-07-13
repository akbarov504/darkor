package uz.darkor.darkor_22.controller.employee.detail;

import uz.darkor.darkor_22.controller.GenericCUDController;
import uz.darkor.darkor_22.controller.GenericGLController;
import uz.darkor.darkor_22.criteria.BaseCriteria;
import uz.darkor.darkor_22.dto.auth.employee_detail.EmployeeDetailCreateDTO;
import uz.darkor.darkor_22.dto.auth.employee_detail.EmployeeDetailGetDTO;
import uz.darkor.darkor_22.dto.auth.employee_detail.EmployeeDetailUpdateDTO;

import java.util.UUID;

public interface EmployeeDetailController
        extends GenericCUDController<EmployeeDetailCreateDTO, EmployeeDetailUpdateDTO, EmployeeDetailGetDTO, UUID>,
        GenericGLController<EmployeeDetailGetDTO, BaseCriteria, UUID> {
}
