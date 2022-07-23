package uz.darkor.darkor_22.service.token;

import uz.darkor.darkor_22.criteria.token.AuthTokenCriteria;
import uz.darkor.darkor_22.dto.auth.token.AuthTokenCreateDTO;
import uz.darkor.darkor_22.dto.auth.token.AuthTokenGetDTO;
import uz.darkor.darkor_22.dto.auth.token.AuthTokenUpdateDTO;
import uz.darkor.darkor_22.service.GenericCUDService;
import uz.darkor.darkor_22.service.GenericGLService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public interface AuthTokenService extends GenericCUDService<AuthTokenCreateDTO, AuthTokenUpdateDTO, AuthTokenGetDTO, UUID>, GenericGLService<AuthTokenGetDTO, AuthTokenCriteria, UUID> {
    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
