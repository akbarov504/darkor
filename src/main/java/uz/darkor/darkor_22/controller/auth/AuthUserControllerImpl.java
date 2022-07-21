package uz.darkor.darkor_22.controller.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.darkor.darkor_22.controller.AbstractController;
import uz.darkor.darkor_22.criteria.BaseCriteria;
import uz.darkor.darkor_22.dto.auth.PasswordDto;
import uz.darkor.darkor_22.dto.auth.auth_user.*;
import uz.darkor.darkor_22.response.Data;
import uz.darkor.darkor_22.service.auth.user.AuthUserService;
import uz.darkor.darkor_22.utils.BaseUtils;

import java.util.List;

@RestController
@RequestMapping(BaseUtils.PATH + "/auth/*")
public class AuthUserControllerImpl extends AbstractController<AuthUserService> implements AuthUserController {

    public AuthUserControllerImpl(AuthUserService service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<AuthUserGetDTO>> create(AuthUserCreateDTO DTO, String lang) {
        return new ResponseEntity<>(new Data<>(service.create(DTO)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<AuthUserGetDTO>> update(AuthUserUpdateDTO DTO, String lang) {
        return new ResponseEntity<>(new Data<>(service.update(DTO)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(Long code, String lang) {
        return new ResponseEntity<>(new Data<>(service.delete(code)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<AuthUserGetDTO>> get(Long code, String lang) {
        return new ResponseEntity<>(new Data<>(service.get(code, lang)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<AuthUserGetDTO>>> list(BaseCriteria criteria, String lang) {
        return new ResponseEntity<>(new Data<>(service.list(criteria, lang)), HttpStatus.OK);
    }

    @RequestMapping(value = {"login","token"}, method = RequestMethod.POST)
    public ResponseEntity<Data<SessionDto>> getToken(@RequestBody LoginDto dto) {
        return service.getToken(dto);
    }

    @PutMapping("resetPassword/{id}")
    public ResponseEntity<Data<Void>> resetPassword(@PathVariable(name = "id") long id,
                                                    @RequestBody PasswordDto dto) {
        dto.setId(id);
        service.resetPassword(dto);
        return new ResponseEntity<>(new Data<>(null), HttpStatus.OK);
    }

}
