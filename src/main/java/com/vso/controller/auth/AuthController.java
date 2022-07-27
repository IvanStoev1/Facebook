package com.vso.controller.auth;


import com.vso.model.entity.User;
import com.vso.model.service.authentication.AuthenticationService;
import com.vso.model.service.authentication.AuthenticationServiceImpl;

import java.util.Scanner;

public class AuthController {

    private final AuthenticationService authentication = new AuthenticationServiceImpl();
    private final Scanner scanner;

    public AuthController() {
        scanner = new Scanner(System.in);
    }

    public void createUser(int age, String name, String email, String password, String repeatPassword, String avatarUrl) {
        if (password.equals(repeatPassword)) {
            authentication.registerUser(email, String.valueOf(password), name, age, avatarUrl);
        }
    }

    public String getTextInput() {
        return scanner.nextLine();
    }

    public void logoutUser() {
        authentication.logout();
    }

    public User getLoggedUser() {
        return AuthenticationServiceImpl.getLoggedUser();
    }
}
