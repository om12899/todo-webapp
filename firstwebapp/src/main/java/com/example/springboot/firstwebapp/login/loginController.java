package com.example.springboot.firstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class loginController {

    private AuthenticationService authenticationService;
    public loginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value="login",method = RequestMethod.GET)
    public String loginPage(){
       // System.out.println("Request : "+name);
        return "login";
    }

    @RequestMapping(value="login",method = RequestMethod.POST)
    public String welcomePage(@RequestParam String name, @RequestParam String password, ModelMap model){

        if(authenticationService.auth(name,password)) {
            model.put("name", name);
           //model.put("password", password);
            //om12899,abc
            // System.out.println("Request : "+name);
            return "loginSuccess";
        }
        model.put("errorMessage", "invalidCredentials try again");
        return "login";
    }
}
