package bookstore.user.service.Exception;

public class InvalidUsernameException extends LoginException {
    @Override
    public String getMessage() {
        return "没有你的用户信息";
    }
}
