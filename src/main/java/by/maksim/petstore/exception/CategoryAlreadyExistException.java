package by.maksim.petstore.exception;

public class CategoryAlreadyExistException extends RuntimeException {
    public CategoryAlreadyExistException() {
    }

    public CategoryAlreadyExistException(String message) {
        super(message);
    }

    public CategoryAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public CategoryAlreadyExistException(Throwable cause) {
        super(cause);
    }

    public CategoryAlreadyExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
