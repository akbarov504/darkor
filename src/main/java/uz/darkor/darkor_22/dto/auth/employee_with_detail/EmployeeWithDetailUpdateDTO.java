package uz.darkor.darkor_22.dto.auth.employee_with_detail;


import lombok.Getter;
import lombok.Setter;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeUpdateDTO;
import uz.darkor.darkor_22.dto.auth.employee_detail.EmployeeDetailUpdateDTO;

@Getter
@Setter
public class EmployeeWithDetailUpdateDTO {

    private EmployeeUpdateDTO profile;

    private EmployeeDetailUpdateDTO detail;

}
