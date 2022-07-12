package uz.darkor.darkor_22.dto.auth.employee_with_detail;

import lombok.Getter;
import lombok.Setter;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeCreateDTO;
import uz.darkor.darkor_22.dto.auth.employee_detail.EmployeeDetailCreateDTO;

@Getter
@Setter
public class EmployeeWithDetailCreatDTO {

    private EmployeeCreateDTO profile;
    private EmployeeDetailCreateDTO detail;

}
