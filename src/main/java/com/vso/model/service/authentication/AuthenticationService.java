package com.vso.model.service.authentication;

import com.vso.model.enumaration.LoginStatus;
import com.vso.model.entity.User;

public interface AuthenticationService {

    boolean registerUser(String email, String password, String name, int age, String avatar_url);

    LoginStatus login(String email, String password);

    boolean checkIfUserExists(String email);

    void logout();

    boolean hasLoggedUser();

}
