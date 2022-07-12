package uz.darkor.darkor_22.mapper.employee;


import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.darkor.darkor_22.dto.auth.employee_detail.EmployeeDetailCreateDTO;
import uz.darkor.darkor_22.dto.auth.employee_detail.EmployeeDetailGetDTO;
import uz.darkor.darkor_22.dto.auth.employee_detail.EmployeeDetailUpdateDTO;
import uz.darkor.darkor_22.entity.auth.EmployeeDetail;
import uz.darkor.darkor_22.mapper.GenericMapper;

@Component
@Mapper(componentModel = "spring")
public interface EmployeeDetailMapper
        extends GenericMapper<EmployeeDetailCreateDTO, EmployeeDetailUpdateDTO, EmployeeDetailGetDTO, EmployeeDetail> {
}
