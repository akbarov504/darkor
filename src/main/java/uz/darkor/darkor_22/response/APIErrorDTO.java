package uz.darkor.darkor_22.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
public class APIErrorDTO {
    private String message;
    private String developerMessage;
    private String path;
    private Integer status;
    private Timestamp date;
}
