package com.vso.model.service;

public interface Authentication {
    boolean registerUser(String clientName, String clientPassword);

    LoginStatus login(String username, String password);

    void logout();

    boolean hasLoggedUser();
}
