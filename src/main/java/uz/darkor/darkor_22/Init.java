package uz.darkor.darkor_22;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uz.darkor.darkor_22.config.encrytion.PasswordEncoderConfigurer;
import uz.darkor.darkor_22.entity.auth.security_utils.AuthUser;
import uz.darkor.darkor_22.repository.auth.AuthUserRepository;

//@Component
public class Init implements CommandLineRunner {
    private final AuthUserRepository repository;
    private final PasswordEncoderConfigurer passwordEncoderConfigurer;

    public Init(AuthUserRepository repository, PasswordEncoderConfigurer passwordEncoderConfigurer) {
        this.repository = repository;
        this.passwordEncoderConfigurer = passwordEncoderConfigurer;
    }

    @Override
    public void run(String... args) throws Exception {
        AuthUser authUser = new AuthUser();
        authUser.setPassword(passwordEncoderConfigurer.passwordEncoder().encode("123"));
        authUser.setEmail("a@gmail.com");
        authUser.setFullName("A a");
        authUser.setPhoneNumber("+998991234567");
        repository.save(authUser);
    }
}
