package uz.darkor.darkor_22.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "service.properties")
public class ServiceProperties {
    private String ip;
    private String port;
    private String url;
    private String protocol;

    public String getServiceUrl() {
        return this.protocol + "://" + this.ip + ":" + this.port;
    }
}
