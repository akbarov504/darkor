package uz.darkor.darkor_22.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "api.info")
public class OpenAPIProperties {
    private String title;
    private String description;
    private String version;
    private String termOfService;
    private String contactName;
    private String contactUrl;
    private String contactEmail;
    private String licenseName;
    private String licenseUrl;
}
