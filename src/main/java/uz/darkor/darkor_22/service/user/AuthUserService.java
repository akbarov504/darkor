package uz.darkor.darkor_22.service.user;

import org.springframework.security.core.userdetails.UserDetailsService;
import uz.darkor.darkor_22.criteria.user.AuthUserCriteria;
import uz.darkor.darkor_22.dto.auth.auth_user.AuthUserCreateDTO;
import uz.darkor.darkor_22.dto.auth.auth_user.AuthUserGetDTO;
import uz.darkor.darkor_22.dto.auth.auth_user.AuthUserUpdateDTO;
import uz.darkor.darkor_22.service.GenericCUDService;
import uz.darkor.darkor_22.service.GenericGLService;

import java.util.UUID;

public interface AuthUserService extends GenericCUDService<AuthUserCreateDTO, AuthUserUpdateDTO, AuthUserGetDTO, UUID>, GenericGLService<AuthUserGetDTO, AuthUserCriteria, UUID>, UserDetailsService {
}
