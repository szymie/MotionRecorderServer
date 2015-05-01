package services;

import entities.User;
import exceptions.InvalidRegisterRequestException;
import exceptions.NoSuchUserFoundException;
import models.RegisterRequest;
import models.RegisterResponse;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UserRepository;
import validators.RegisterRequestValidator;

/**
 * Created by Szymon on 2015-04-27.
 */
@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RegisterRequestValidator requestValidator;
    private RegisterResponse response;
    private boolean usernameFree;

    public RegisterResponse processRegisterResponse(RegisterRequest request) throws InvalidRegisterRequestException {

        requestValidator.validate(request);

        registerUser(request);
        createResponse(request);

        return response;
    }

    private void registerUser(RegisterRequest request) {

        checkIfUsernameFree(request.getUsername());

        if(usernameFree)
            userRepository.saveUser( new User(request) );
    }

    private void checkIfUsernameFree(String username) {

        try {
            userRepository.findUserByUsername(username);
            usernameFree = false;
        } catch(NoSuchUserFoundException e) {
            usernameFree = true;
        }
    }

    private void createResponse(RegisterRequest request) {

        if(usernameFree)
            response = new RegisterResponse(usernameFree, "Rejestracja zakoñczona powodzeniem");
        else
            response = new RegisterResponse(usernameFree, "U¿ytkownik '" + request.getUsername() + "' ju¿ istnieje");
    }
}
