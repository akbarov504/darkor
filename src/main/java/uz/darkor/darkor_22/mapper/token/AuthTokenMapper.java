package uz.darkor.darkor_22.mapper.token;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.darkor.darkor_22.dto.auth.token.AuthTokenCreateDTO;
import uz.darkor.darkor_22.dto.auth.token.AuthTokenGetDTO;
import uz.darkor.darkor_22.dto.auth.token.AuthTokenUpdateDTO;
import uz.darkor.darkor_22.entity.auth.token.AuthToken;
import uz.darkor.darkor_22.mapper.GenericMapper;

@Component
@Mapper(componentModel = "spring")
public interface AuthTokenMapper extends GenericMapper<AuthTokenCreateDTO, AuthTokenUpdateDTO, AuthTokenGetDTO, AuthToken> {
    AuthToken toCreateDTO(AuthTokenCreateDTO dto);
}
