package usecases;

import models.LoginRequest;
import models.LoginResponse;

/**
 * Created by Szymon on 2015-04-25.
 */
public interface LoginUser {

    public LoginResponse execute(LoginRequest request);
}
