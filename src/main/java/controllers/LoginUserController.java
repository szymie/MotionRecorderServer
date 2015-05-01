package controllers;


import models.LoginRequest;
import models.LoginResponse;
import usecases.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Szymon on 2015-04-25.
 */
@Controller
public class LoginUserController {

    @Autowired
    private LoginUser loginUserUseCase;

    @RequestMapping(
            value = "/login",
            method = RequestMethod.POST,
            headers = {"Accept=application/json", "Content-Type=application/json"}, produces={"application/json; charset=UTF-8"})
    public @ResponseBody LoginResponse login(@RequestBody LoginRequest request) {

        return loginUserUseCase.execute(request);
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index() {

        return "index";
    }


}
