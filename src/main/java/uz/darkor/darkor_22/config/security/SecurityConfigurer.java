package uz.darkor.darkor_22.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import uz.darkor.darkor_22.config.encryption.PasswordEncoderConfigurer;
import uz.darkor.darkor_22.config.security.filters.CustomAuthenticationFilter;
import uz.darkor.darkor_22.config.security.filters.CustomAuthorizationFilter;
import uz.darkor.darkor_22.service.token.AuthTokenService;
import uz.darkor.darkor_22.service.user.AuthUserService;
import uz.darkor.darkor_22.utils.BaseUtils;

import java.util.Arrays;
import java.util.List;

@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    private static final String[] ALLOWED_METHODS = {"GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"};
    private static final String[] ALLOWED_HEADERS = {
            "accept", "cache-Control", "authorization", "content-type", "x-auth-token", "cookie", "set-cookie",
            "content-disposition", "dnt", "if-modified-since", "keep-alive", "origin", "user-agent", "x-requested-with"
    };


    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(List.of("*"));
        configuration.setAllowedMethods(Arrays.asList(ALLOWED_METHODS));
        configuration.setAllowedHeaders(Arrays.asList(ALLOWED_HEADERS));
//        configuration.setAllowCredentials(true);
//        configuration.setMaxAge(MAX_AGE);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    public static final String[] WHITE_LIST = {
            "/swagger-ui/**",
            "/swagger-documentation/**",
            BaseUtils.PATH + "/login",
            BaseUtils.PATH + "/auth/login",
            BaseUtils.PATH + "/auth/register"
    };

    private final AuthUserService service;
    private final AuthTokenService authTokenService;
    private final PasswordEncoderConfigurer configurer;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(service).passwordEncoder(configurer.encoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.cors();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http
                .authorizeRequests()
                .antMatchers(WHITE_LIST)
                .permitAll()
                .anyRequest()
                .authenticated();

        http.addFilter(new CustomAuthenticationFilter(authTokenService, authenticationManagerBean()));
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
