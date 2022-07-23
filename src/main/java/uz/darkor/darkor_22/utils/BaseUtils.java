package uz.darkor.darkor_22.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.client.RestTemplate;

@Getter
@Setter
public class BaseUtils {

    private static String sessionLang;
    public static final String API = "/api";
    public static final String VERSION = "/v1";
    public static final String PATH = API + VERSION;
    public static final String CREATE_PATH = "create";
    public static final String UPDATE_PATH = "update";
    public static final String DELETE_PATH = "delete/{code}";
    public static final String GET_PATH = "get/{code}";
    public static final String LIST_PATH = "list";

    public static final RestTemplate TEMPLATE = new RestTemplate();

    public static String getSessionLang() {
        return sessionLang;
    }

    public static void setSessionLang(String sessionLang) {
        BaseUtils.sessionLang = sessionLang;
    }
}
