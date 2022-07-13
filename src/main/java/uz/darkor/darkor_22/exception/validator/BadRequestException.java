package uz.darkor.darkor_22.exception.validator;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }
}
