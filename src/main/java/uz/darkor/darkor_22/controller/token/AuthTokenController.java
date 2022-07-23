package uz.darkor.darkor_22.controller.token;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uz.darkor.darkor_22.controller.AbstractController;
import uz.darkor.darkor_22.service.token.AuthTokenServiceImpl;
import uz.darkor.darkor_22.utils.BaseUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/auth/")
public class AuthTokenController extends AbstractController<AuthTokenServiceImpl> {
    public AuthTokenController(AuthTokenServiceImpl service) {
        super(service);
    }

    @RequestMapping(value = "refresh-token", method = RequestMethod.GET)
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        service.refreshToken(request, response);
    }
}
