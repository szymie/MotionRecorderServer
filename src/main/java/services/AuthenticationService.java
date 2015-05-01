package services;

import exceptions.InvalidLoginRequestException;
import models.LoginRequest;
import models.LoginResponse;

/**
 * Created by Szymon on 2015-04-26.
 */
public interface AuthenticationService {

    public LoginResponse processLoginRequest(LoginRequest request) throws InvalidLoginRequestException;
}
