package services;

import entities.User;
import exceptions.InvalidLoginRequestException;
import exceptions.NoSuchUserFoundException;
import models.LoginRequest;
import models.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UserRepository;

/**
 * Created by Szymon on 2015-04-26.
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;
    private User user;
    private LoginResponse response;
    private boolean passwordCorrect;

    public LoginResponse processLoginRequest(LoginRequest request) throws InvalidLoginRequestException {

        try {
            user = userRepository.findUserByUsername(request.getUsername());
            checkPasswordCorrectness(request.getPassword());
            createResponse();
        } catch(NoSuchUserFoundException e) {
            throw new InvalidLoginRequestException(e.getMessage());
        }

        return response;
    }

    private void checkPasswordCorrectness(String password) {

        String correctPassword = user.getPassword();

        if(correctPassword.equals(password))
            passwordCorrect = true;
        else
            passwordCorrect = false;
    }

    private void createResponse() {

        if(passwordCorrect)
            response = new LoginResponse(user.getUsername(), passwordCorrect, "Hasło poprawne");
        else
            response = new LoginResponse(user.getUsername(), passwordCorrect, "Hasło niepoprawne");
    }

}
