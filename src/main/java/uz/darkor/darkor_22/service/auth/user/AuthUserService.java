package uz.darkor.darkor_22.service.auth.user;

import org.springframework.http.ResponseEntity;
import uz.darkor.darkor_22.criteria.BaseCriteria;
import uz.darkor.darkor_22.dto.auth.PasswordDto;
import uz.darkor.darkor_22.dto.auth.auth_user.*;
import uz.darkor.darkor_22.response.Data;
import uz.darkor.darkor_22.service.BaseService;
import uz.darkor.darkor_22.service.GenericCUDService;
import uz.darkor.darkor_22.service.GenericGLService;

public interface AuthUserService extends GenericCUDService<AuthUserCreateDTO, AuthUserUpdateDTO, AuthUserGetDTO, Long>,
        GenericGLService<AuthUserGetDTO, BaseCriteria, Long>, BaseService {
    void resetPassword(PasswordDto dto);

    ResponseEntity<Data<SessionDto>> getToken(LoginDto dto);
}
