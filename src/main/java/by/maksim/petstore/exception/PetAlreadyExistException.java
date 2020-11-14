package by.maksim.petstore.exception;

public class PetAlreadyExistException extends RuntimeException {
    public PetAlreadyExistException() {
    }

    public PetAlreadyExistException(String message) {
        super(message);
    }

    public PetAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public PetAlreadyExistException(Throwable cause) {
        super(cause);
    }

    public PetAlreadyExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
