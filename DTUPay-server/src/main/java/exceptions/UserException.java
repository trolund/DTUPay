package exceptions;

public class UserException extends Exception {

    public UserException(String message) {
        super(message, null);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }
}

