package service.Exception;

public class NameNullException extends LoginException {
    @Override
    public String getMessage() {
        return "用户名是空的";
    }
}
