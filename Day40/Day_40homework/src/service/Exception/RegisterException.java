package service.Exception;

public class RegisterException extends Exception {
    @Override
    public String getMessage() {
        return "你的账户重名了";
    }
}
