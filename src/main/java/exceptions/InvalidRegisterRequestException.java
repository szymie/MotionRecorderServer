package exceptions;

/**
 * Created by Szymon on 2015-04-27.
 */
public class InvalidRegisterRequestException extends RuntimeException {

    public InvalidRegisterRequestException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
