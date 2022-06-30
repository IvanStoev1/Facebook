package com.vso.controller;

import com.vso.model.LoginStatus;
import com.vso.model.UserAuthForm;
import com.vso.model.UserDao;
import com.vso.model.service.*;
import com.vso.view.AuthView;

public class Controller {

    private final AuthenticationService authentication;
    private final UserDao database;
    private final UserAuthForm form;
    private final AuthView authView;

    public Controller(AuthenticationService authentication, UserDao database, AuthView authView) {
        this.authentication = authentication;
        this.database = database;
        this.form = new UserAuthForm();
        this.authView = authView;

    }

    public void initializeProgram() {
        while (true) {
            if (authentication.hasLoggedUser()) {
                processLoggedUserOptions();
            } else {
                authenticateUser();
            }
        }
    }


    private void authenticateUser() {
        authView.show(authView.getNonRegisteredUserOptions());
        int userChoice = authView.getNumberInput();

        switch (userChoice) {
            case 1:
                initLoginProcess();
                break;
            case 2:
                initCreateUserProcess();
                break;
            default:
                System.out.println("No such option");
        }

    }

    private void processLoggedUserOptions() {
        authView.show(authView.getUserOptions());
        int userChoice = authView.getNumberInput();
        switch (userChoice) {
            case 1:
                authentication.logout();
                break;
        }
    }


    private void initLoginProcess() {
        String[] input = this.form.processLoginForm();
        String email = input[0];
        String password = input[1];
        LoginStatus loginStatus = authentication.login(email, password);
        if (loginStatus == LoginStatus.LOGIN_FAILED) {
            authView.show("Login failed");
        } else {
            authView.show("Login successful");
        }

    }

    private void initCreateUserProcess() {
        String[] input = this.form.processForm();
        int age = Integer.parseInt(input[0]);
        String name = input[1];
        String email = input[2];
        String password = input[3];
        String repeatPassword = input[4];

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
