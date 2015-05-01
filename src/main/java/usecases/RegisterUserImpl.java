package usecases;

import exceptions.InvalidLoginRequestException;
import exceptions.InvalidRegisterRequestException;
import models.LoginResponse;
import models.RegisterRequest;
import models.RegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import services.RegisterService;

/**
 * Created by Szymon on 2015-04-26.
 */
@Component
public class RegisterUserImpl implements RegisterUser {

    @Autowired
    private RegisterService registerService;
    private RegisterResponse response;

    public RegisterResponse execute(RegisterRequest request) {

        try {
            response = registerService.processRegisterResponse(request);
        } catch (InvalidRegisterRequestException e) {
            response = new RegisterResponse(false, e.getMessage());
        }

        return response;
    }
}
