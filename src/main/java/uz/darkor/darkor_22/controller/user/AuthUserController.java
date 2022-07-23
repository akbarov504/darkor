package uz.darkor.darkor_22.controller.user;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uz.darkor.darkor_22.controller.AbstractController;
import uz.darkor.darkor_22.dto.auth.auth_user.AuthUserCreateDTO;
import uz.darkor.darkor_22.dto.auth.auth_user.AuthUserLoginDTO;
import uz.darkor.darkor_22.service.user.AuthUserServiceImpl;
import uz.darkor.darkor_22.utils.BaseUtils;

import javax.validation.Valid;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/auth/")
public class AuthUserController extends AbstractController<AuthUserServiceImpl> {
    public AuthUserController(AuthUserServiceImpl service) {
        super(service);
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Object login(@Valid @RequestBody AuthUserLoginDTO dto) {
        HttpEntity<AuthUserLoginDTO> entity = new HttpEntity<>(dto);
        ResponseEntity<Object> exchange = BaseUtils.TEMPLATE.exchange("http://localhost:8080/api/v1/login", HttpMethod.POST, entity, Object.class);
        return exchange.getBody();
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(@Valid @RequestBody AuthUserCreateDTO dto) {
        service.create(dto);
        return "successfully registered";
    }
}
