package uz.darkor.darkor_22.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class APIErrorDTO {
    private String message;
    private String developerMessage;
    private String path;
    private Integer status;
    private Timestamp date;
}
