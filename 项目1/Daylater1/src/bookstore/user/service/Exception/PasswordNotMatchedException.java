package bookstore.user.service.Exception;

public class PasswordNotMatchedException extends LoginException {
    @Override
    public String getMessage() {
        return "你的密码错误";
    }
}
