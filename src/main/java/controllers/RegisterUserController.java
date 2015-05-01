package controllers;

import models.RegisterRequest;
import models.RegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import usecases.RegisterUser;

/**
 * Created by Szymon on 2015-04-27.
 */
@Controller
public class RegisterUserController {

    @Autowired
    RegisterUser registerUserUseCase;

    @RequestMapping(
            value = "/register",
            method = RequestMethod.POST,
            headers = {"Accept=application/json", "Content-Type=application/json"}, produces={"application/json; charset=UTF-8"})
    public @ResponseBody RegisterResponse login(@RequestBody RegisterRequest request) {

        return registerUserUseCase.execute(request);
    }

}
