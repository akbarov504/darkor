package uz.darkor.darkor_22.mapper.auth;

import org.mapstruct.Mapper;
import uz.darkor.darkor_22.dto.auth.auth_role.AuthRoleGetDTO;
import uz.darkor.darkor_22.dto.auth.auth_user.AuthUserCreateDTO;
import uz.darkor.darkor_22.dto.auth.auth_user.AuthUserGetDTO;
import uz.darkor.darkor_22.dto.auth.auth_user.AuthUserUpdateDTO;
import uz.darkor.darkor_22.entity.auth.security_utils.AuthUser;
import uz.darkor.darkor_22.mapper.GenericMapper;
@Mapper(componentModel = "spring")
public interface AuthUserMapper extends GenericMapper<AuthUserCreateDTO, AuthUserUpdateDTO, AuthUserGetDTO, AuthUser> {
}
