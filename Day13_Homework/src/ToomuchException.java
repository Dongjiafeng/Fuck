public class ToomuchException extends Exception {
    @Override
    public String getMessage() {
        return "密码太长";
    }
}
