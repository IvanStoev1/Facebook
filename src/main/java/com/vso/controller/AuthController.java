package com.vso.controller;


import com.vso.model.service.authentication.AuthenticationService;
import com.vso.model.service.uploadPost.UploadingService;

import java.util.Scanner;

import java.io.File;

public class AuthController {

    private final AuthenticationService authentication;
    private final Scanner scanner;



    public AuthController(AuthenticationService authentication) {
        this.authentication = authentication;
        scanner = new Scanner(System.in);
    }

    public void createUser(int age, String name, String email, String password, String repeatPassword, String avatarUrl) {
        if (password.equals(repeatPassword)) {
            authentication.registerUser(email, password, name, age, avatarUrl);
        }
    }

    public String getTextInput() {
        return scanner.nextLine();
    }

    public void processLoggedUserOptions() {
        switch (scanner.nextInt()) {
            case 1:
                authentication.logout();
                break;


        }
    }
}
