package validators;

import exceptions.InvalidRegisterRequestException;
import models.RegisterRequest;

/**
 * Created by Szymon on 2015-04-27.
 */
public interface RegisterRequestValidator {

    public void validate(RegisterRequest registerRequest) throws InvalidRegisterRequestException;
}
