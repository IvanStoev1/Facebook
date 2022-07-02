package com.vso.model.service.authentication;

import com.vso.model.constant.LoginStatus;

public interface AuthenticationService {
    boolean registerUser(String email,String password,String name,int age);

    LoginStatus login(String email, String password);

    void logout();

    boolean hasLoggedUser();
}
