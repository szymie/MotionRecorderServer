package usecases;


import entities.User;
import exceptions.InvalidLoginRequestException;
import exceptions.NoSuchUserFoundException;
import models.LoginRequest;
import models.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repositories.UserRepository;
import services.AuthenticationService;

/**
 * Created by Szymon on 2015-04-25.
 */
@Component
public class LoginUserImpl implements LoginUser {

    @Autowired
    private AuthenticationService authenticationService;
    private LoginResponse response;

    public LoginResponse execute(LoginRequest request) {

        try {
            response = authenticationService.processLoginRequest(request);
        } catch (InvalidLoginRequestException e) {
            response = new LoginResponse(request.getUsername(), false, e.getMessage());
        }

        return response;
    }
}
