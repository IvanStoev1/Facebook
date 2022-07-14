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
            boolean registerIsSuccessful = authentication.registerUser(email, password, name, age);
            if (registerIsSuccessful) {
                authView.show("Registration successful");
            } else {
                authView.show("Such user exists.");
            }
        } else {
            authView.show("Passwords should match");
        }
    }
}
