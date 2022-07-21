package uz.darkor.darkor_22.controller.auth;

import uz.darkor.darkor_22.controller.GenericCUDController;
import uz.darkor.darkor_22.controller.GenericGLController;
import uz.darkor.darkor_22.criteria.BaseCriteria;
import uz.darkor.darkor_22.dto.auth.auth_user.AuthUserCreateDTO;
import uz.darkor.darkor_22.dto.auth.auth_user.AuthUserGetDTO;
import uz.darkor.darkor_22.dto.auth.auth_user.AuthUserUpdateDTO;

public interface AuthUserController extends GenericCUDController<AuthUserCreateDTO, AuthUserUpdateDTO, AuthUserGetDTO,Long>,
        GenericGLController<AuthUserGetDTO, BaseCriteria,Long> {
}
