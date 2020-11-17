package by.maksim.petstore.exception;

public class OrderAlreadyExistException extends RuntimeException {
    public OrderAlreadyExistException() {
    }

    public OrderAlreadyExistException(String message) {
        super(message);
    }

    public OrderAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderAlreadyExistException(Throwable cause) {
        super(cause);
    }

    public OrderAlreadyExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
