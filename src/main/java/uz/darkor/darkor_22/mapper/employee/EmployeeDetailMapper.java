package uz.darkor.darkor_22.mapper.employee;


import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.darkor.darkor_22.dto.auth.employee_detail.EmployeeDetailCreateDTO;
import uz.darkor.darkor_22.dto.auth.employee_detail.EmployeeDetailGetDTO;
import uz.darkor.darkor_22.dto.auth.employee_detail.EmployeeDetailUpdateDTO;
import uz.darkor.darkor_22.entity.employee.EmployeeDetail;
import uz.darkor.darkor_22.mapper.GenericMapper;
import uz.darkor.darkor_22.mapper.course.CourseMapper;

@Mapper(componentModel = "spring", uses = {CourseMapper.class, GenericMapper.class/*, EmployeeMapper.class*/})
public interface EmployeeDetailMapper
        extends GenericMapper<EmployeeDetailCreateDTO, EmployeeDetailUpdateDTO, EmployeeDetailGetDTO, EmployeeDetail> {
}
