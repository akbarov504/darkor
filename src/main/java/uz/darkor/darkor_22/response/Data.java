package uz.darkor.darkor_22.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class  Data<T> {
    protected T body;
    protected Long totalCount;
    protected boolean isSuccess;
    protected APIErrorDTO error;

    public Data(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Data(T body) {
        this(true);
        this.body = body;
    }

    public Data(APIErrorDTO error) {
        this(false);
        this.error = error;
    }

    public Data(T body, Long totalCount) {
        this(body);
        this.totalCount = totalCount;
    }
}
