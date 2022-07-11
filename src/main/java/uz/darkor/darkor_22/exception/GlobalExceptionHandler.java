package uz.darkor.darkor_22.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import uz.darkor.darkor_22.exception.validator.ValidationException;
import uz.darkor.darkor_22.response.APIErrorDTO;
import uz.darkor.darkor_22.response.Data;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({ValidationException.class})
    public ResponseEntity<Data<APIErrorDTO>> valid(ValidationException ex, WebRequest request) {
        APIErrorDTO path = APIErrorDTO.builder().developerMessage(ex.getStackTrace().toString()).message(ex.getMessage()).status(HttpStatus.CONFLICT.value()).path(request.getContextPath()).build();
        return new ResponseEntity<>(new Data<>(path), HttpStatus.OK);
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Data<APIErrorDTO>> notFound(NotFoundException ex, WebRequest request) {
        APIErrorDTO path = APIErrorDTO.builder().developerMessage(ex.getMessage()).status(HttpStatus.NOT_FOUND.value()).path(request.getContextPath()).build();
        return new ResponseEntity<>(new Data<>(path), HttpStatus.OK);
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Data<APIErrorDTO>> run(RuntimeException e, WebRequest request) {
        APIErrorDTO path = APIErrorDTO.builder().developerMessage(e.getMessage()).status(HttpStatus.NOT_FOUND.value()).path(request.getContextPath()).build();
        return new ResponseEntity<>(new Data<>(path), HttpStatus.OK);
    }

    @ExceptionHandler({UserAlreadyTaken.class})
    public ResponseEntity<Data<APIErrorDTO>> run(UserAlreadyTaken e, WebRequest request) {
        APIErrorDTO path = APIErrorDTO.builder().developerMessage(e.getMessage()).status(HttpStatus.NOT_FOUND.value()).path(request.getContextPath()).build();
        return new ResponseEntity<>(new Data<>(path), HttpStatus.OK);
    }

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<Data<APIErrorDTO>> run(UserNotFoundException e, WebRequest request) {
        APIErrorDTO path = APIErrorDTO.builder().developerMessage(e.getMessage()).status(HttpStatus.NOT_FOUND.value()).path(request.getContextPath()).build();
        return new ResponseEntity<>(new Data<>(path), HttpStatus.OK);
    }
}
