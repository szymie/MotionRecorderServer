package exceptions;

/**
 * Created by Szymon on 2015-04-05.
 */
public class NoSuchUserFoundException extends RuntimeException {

    public NoSuchUserFoundException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return getMessage();
    }

}
