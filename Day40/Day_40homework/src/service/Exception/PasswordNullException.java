package service.Exception;

public class PasswordNullException extends LoginException {
    @Override
    public String getMessage() {
        return "密码不一致";
    }
}
