package com.example.springboot.firstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean auth(String username, String password){
        boolean validUsername = username.equalsIgnoreCase("om12899");
        boolean validPassword = password.equals("abc");
        return validPassword && validUsername;
    }
}
