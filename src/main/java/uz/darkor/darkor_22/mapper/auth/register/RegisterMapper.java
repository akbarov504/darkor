package uz.darkor.darkor_22.mapper.auth.register;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.darkor.darkor_22.dto.auth.register.RegisterCreateDTO;
import uz.darkor.darkor_22.dto.auth.register.RegisterGetDTO;
import uz.darkor.darkor_22.dto.auth.register.RegisterUpdateDTO;
import uz.darkor.darkor_22.entity.auth.Register;
import uz.darkor.darkor_22.mapper.GenericMapper;

@Component
@Mapper(componentModel = "spring")
public interface RegisterMapper extends GenericMapper<RegisterCreateDTO, RegisterUpdateDTO, RegisterGetDTO, Register> {
}
