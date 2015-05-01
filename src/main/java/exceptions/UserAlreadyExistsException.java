package exceptions;

/**
 * Created by Szymon on 2015-04-27.
 */
public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
