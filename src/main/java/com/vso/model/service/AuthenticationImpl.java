package com.vso.model.service;

import com.vso.model.entity.User;

import java.util.Scanner;

public class AuthenticationImpl implements Authentication{

    private User loggedUser;

    public AuthenticationImpl() {
        this.loggedUser = null;
    }


    @Override
    public boolean registerUser(String email, String clientPassword) {
        User user = new User(email, clientPassword);
        return true;

    }

    @Override
    public LoginStatus login(String email, String password) {
        return null;
    }

    @Override
    public void logout() {
        this.loggedUser = null;

    }

    @Override
    public boolean hasLoggedUser() {
        return loggedUser != null;

    }

}
