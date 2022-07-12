package uz.darkor.darkor_22.mapper.employee;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeCreateDTO;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeGetDTO;
import uz.darkor.darkor_22.dto.auth.employee.EmployeeUpdateDTO;
import uz.darkor.darkor_22.entity.auth.Employee;
import uz.darkor.darkor_22.mapper.GenericMapper;

@Component
@Mapper(componentModel = "spring")
public interface EmployeeMapper extends GenericMapper<EmployeeCreateDTO, EmployeeUpdateDTO, EmployeeGetDTO, Employee> {
}
