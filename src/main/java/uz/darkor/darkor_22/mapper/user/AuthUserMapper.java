package uz.darkor.darkor_22.mapper.user;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.darkor.darkor_22.dto.auth.auth_user.AuthUserCreateDTO;
import uz.darkor.darkor_22.dto.auth.auth_user.AuthUserGetDTO;
import uz.darkor.darkor_22.dto.auth.auth_user.AuthUserUpdateDTO;
import uz.darkor.darkor_22.entity.auth.AuthUser;
import uz.darkor.darkor_22.mapper.GenericMapper;

@Component
@Mapper(componentModel = "spring")
public interface AuthUserMapper extends GenericMapper<AuthUserCreateDTO, AuthUserUpdateDTO, AuthUserGetDTO, AuthUser> {
    AuthUser toCreateDTO(AuthUserCreateDTO dto);
}
