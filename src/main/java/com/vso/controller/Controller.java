package com.vso.controller;

import com.vso.model.service.*;
import com.vso.view.ViewModel;

public class Controller {

    private final AuthenticationService authentication;
    Communication communication;
    private final UserDao database;
    private final Forms forms;
    private final ViewModel viewModel;

    public Controller(AuthenticationService authentication, UserDao database, Communication communication ) {
        this.authentication = authentication;
        this.database = database;
        this.communication = communication;
        this.forms = new Forms();
        this.viewModel = new ViewModel();

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
        communication.show(viewModel.getNonRegisteredUserOptions());
        int userChoice = communication.getNumberInput();

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
        communication.show(viewModel.getUserOptions());
        int userChoice = communication.getNumberInput();
        switch (userChoice) {
            case 1:
                authentication.logout();
                break;
        }
    }


    private void initLoginProcess() {
        String[] input = this.forms.processLoginForm();
        String email = input[0];
        String password = input[1];
        LoginStatus loginStatus = authentication.login(email, password);
        if (loginStatus == LoginStatus.LOGIN_FAILED) {
            communication.show("Login failed");
        } else {
            communication.show("Login successful");
        }

    }

    private void initCreateUserProcess() {
        String[] input = this.forms.processForm();
        int age = Integer.parseInt(input[0]);
        String name = input[1];
        String email = input[2];
        String password = input[3];
        String repeatPassword = input[4];

        if (password.equals(repeatPassword)) {
            boolean registerIsSuccessful = authentication.registerUser(email, password,name,age);
            if (registerIsSuccessful) {
                communication.show("Registration successful");
            } else {
                communication.show("Such user exists.");
            }
        } else {
            communication.show("Passwords should match");
        }
    }

}
