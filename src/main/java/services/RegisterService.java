package services;

import exceptions.InvalidRegisterRequestException;
import models.RegisterRequest;
import models.RegisterResponse;

/**
 * Created by Szymon on 2015-04-27.
 */
public interface RegisterService {

    public RegisterResponse processRegisterResponse(RegisterRequest request) throws InvalidRegisterRequestException;
}
