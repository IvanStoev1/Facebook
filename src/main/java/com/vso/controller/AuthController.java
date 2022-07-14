package com.vso.controller;


import com.vso.model.service.authentication.AuthenticationServiceImpl;
import com.vso.model.service.authentication.AuthenticationService;
import com.vso.view.AuthView;

public class AuthController {

    private final AuthenticationService authentication;
    private final AuthView authView;

    public AuthController(AuthenticationService authentication, AuthView authView) {
        this.authentication = authentication;
        this.authView = authView;

    }

    public void createUser(int age, String name, String email, String password, String repeatPassword) {
        if (password.equals(repeatPassword)) {
            authentication.registerUser(email, password, name, age);
        }
    }
}
