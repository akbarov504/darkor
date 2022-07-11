package uz.darkor.darkor_22;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import uz.darkor.darkor_22.properties.OpenAPIProperties;
import uz.darkor.darkor_22.properties.ServiceProperties;

@OpenAPIDefinition
@SpringBootApplication
@EnableTransactionManagement
@EnableConfigurationProperties({OpenAPIProperties.class, ServiceProperties.class})
public class Darkor22Application {
    public static void main(String[] args) {
        SpringApplication.run(Darkor22Application.class, args);
    }
}
