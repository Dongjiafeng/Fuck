package bookstore.user.service.Exception;

public class NotemailException extends RegisterException {
    @Override
    public String getMessage() {
        return "请输入邮箱帐号";
    }
}
