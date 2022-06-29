package com.vso.model.service;

public interface Authentication {
    boolean registerUser(String email,String password);

    LoginStatus login(String email,String password);

    void logout();

    boolean hasLoggedUser();
}
