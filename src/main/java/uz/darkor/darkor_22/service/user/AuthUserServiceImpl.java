package uz.darkor.darkor_22.service.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import uz.darkor.darkor_22.config.encryption.PasswordEncoderConfigurer;
import uz.darkor.darkor_22.criteria.user.AuthUserCriteria;
import uz.darkor.darkor_22.dto.auth.auth_user.AuthUserCreateDTO;
import uz.darkor.darkor_22.dto.auth.auth_user.AuthUserGetDTO;
import uz.darkor.darkor_22.dto.auth.auth_user.AuthUserUpdateDTO;
import uz.darkor.darkor_22.entity.auth.AuthUser;
import uz.darkor.darkor_22.entity.auth.session.SessionUser;
import uz.darkor.darkor_22.enums.AuthRole;
import uz.darkor.darkor_22.mapper.user.AuthUserMapper;
import uz.darkor.darkor_22.repository.user.AuthUserRepository;
import uz.darkor.darkor_22.service.AbstractService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@Transactional
public class AuthUserServiceImpl extends AbstractService<AuthUserMapper, AuthUserRepository> implements AuthUserService {
    public AuthUserServiceImpl(AuthUserMapper mapper, AuthUserRepository repository) {
        super(mapper, repository);
    }

    @Override
    public AuthUserGetDTO create(AuthUserCreateDTO DTO) {
        PasswordEncoderConfigurer encoderConfigurer = new PasswordEncoderConfigurer();
        AuthUser user = mapper.toCreateDTO(DTO);
        user.setPassword(encoderConfigurer.encoder().encode(user.getPassword()));
        user.setRole(AuthRole.USER);
        return mapper.toGetDTO(repository.save(user));
    }

    @Override
    public AuthUserGetDTO update(AuthUserUpdateDTO DTO) {
        return null;
    }

    @Override
    public Boolean delete(UUID key) {
        return null;
    }

    @Override
    public AuthUserGetDTO get(UUID key, String language) {
        return null;
    }

    @Override
    public List<AuthUserGetDTO> list(AuthUserCriteria criteria, String language) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser user = repository.findByEmail(username);
        if (Objects.isNull(user)) {
            throw new NotFoundException("User not found");
        }
        return new SessionUser(user);
    }
}
