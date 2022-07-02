package com.vso.model.service.authentication;

import com.vso.view.AuthView;

public class UserAuthForm {

    private final AuthView authView;

    public UserAuthForm() {
        this.authView = new AuthView();
    }

    public String[] processForm() {
        authView.show("Enter age");
        int age = authView.getNumberInput();
        while (age < 14) {
            authView.show("You need to be 14 or older to make an account");
            age = authView.getNumberInput();
        }
        authView.show("Enter name");
        String name = authView.getTextInput();
        authView.show("Enter email:");
        String email = authView.getTextInput();
        authView.show("Enter password:");
        String password = authView.getTextInput();
        authView.show("Enter password again:");
        String repeatPassword = authView.getTextInput();
        return new String[]{String.valueOf(age), name, email, password, repeatPassword};
    }

    public String[] processLoginForm() {
        authView.show("Enter email:");
        String email = authView.getTextInput();
        authView.show("Enter password:");
        String password = authView.getTextInput();
        return new String[]{email, password};
    }
}