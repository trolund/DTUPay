package exceptions;

public class TransactionException extends Exception {

    public TransactionException(String message) {
        super(message, null);
    }

    public TransactionException(String message, Throwable cause) {
        super(message, cause);
    }
}
