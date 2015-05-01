package usecases;


import models.RegisterRequest;
import models.RegisterResponse;

/**
 * Created by Szymon on 2015-04-26.
 */
public interface RegisterUser {

    public RegisterResponse execute(RegisterRequest request);
}
