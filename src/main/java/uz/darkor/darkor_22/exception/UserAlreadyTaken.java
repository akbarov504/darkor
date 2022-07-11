package uz.darkor.darkor_22.exception;

public class UserAlreadyTaken extends RuntimeException{

    public UserAlreadyTaken(String message) {
        super(message);
    }
}
