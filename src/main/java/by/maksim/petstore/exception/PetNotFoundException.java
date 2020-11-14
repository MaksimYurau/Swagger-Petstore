package by.maksim.petstore.exception;

public class PetNotFoundException extends RuntimeException {
    public PetNotFoundException() {
    }

    public PetNotFoundException(String message) {
        super(message);
    }

    public PetNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PetNotFoundException(Throwable cause) {
        super(cause);
    }

    public PetNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
