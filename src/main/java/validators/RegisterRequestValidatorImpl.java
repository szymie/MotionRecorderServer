package validators;

import exceptions.InvalidRegisterRequestException;
import models.RegisterRequest;
import org.springframework.stereotype.Component;

/**
 * Created by Szymon on 2015-04-27.
 */
@Component
public class RegisterRequestValidatorImpl implements RegisterRequestValidator {
    @Override
    public void validate(RegisterRequest registerRequest) throws InvalidRegisterRequestException {

        if(registerRequest.getUsername().trim().isEmpty())
            throw new InvalidRegisterRequestException("Pole 'nazwa u¿ytkownika' jest puste");

        if(registerRequest.getPassword().isEmpty())
            throw new InvalidRegisterRequestException("Pole 'has³o' jest puste");

        if(registerRequest.getWeight() <= 0)
            throw new InvalidRegisterRequestException("Pole 'waga' zawiera niepoprawn¹ wartoœæ");

        if(registerRequest.getHeight() <= 0)
            throw new InvalidRegisterRequestException("Pole 'wzrost' zawiera niepoprawn¹ wartoœæ");
    }
}
