package uz.darkor.darkor_22.config.encrytion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderConfigurer {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(6);
    }
}
