package uz.darkor.darkor_22.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import uz.darkor.darkor_22.config.security.filter.CustomAuthenticationFilter;
import uz.darkor.darkor_22.config.security.filter.CustomAuthorizationFilter;
import uz.darkor.darkor_22.utils.BaseUtils;

@Configuration
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class SecurityConfigurer extends GlobalMethodSecurityConfiguration {

    public static final String[] WHITE_LIST = {
            BaseUtils.PATH + "/auth/login",
            BaseUtils.PATH + "/auth/register",
            BaseUtils.PATH + "/token",
            "/swagger-ui/**",
            "/api-docs/**",
            BaseUtils.PATH + "/auth/accept/**"
    };


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(WHITE_LIST).permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
//                .exceptionHandling().authenticationEntryPoint(userAuthenticationEntryPoint)
                .csrf().disable()
                .cors().disable();

        return http.build();


    }


}
