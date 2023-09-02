package commons;

public class NotAuthorizeException extends RuntimeException{
    public NotAuthorizeException () {
        super("접근 권한이 없습니다.");
    }
}
