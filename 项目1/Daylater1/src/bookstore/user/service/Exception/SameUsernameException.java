package bookstore.user.service.Exception;

public class SameUsernameException extends RegisterException{
    @Override
    public String getMessage() {
        return "你的用户名重复";
    }
}
