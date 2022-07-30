package com.vso.controller.auth;


import com.vso.model.dao.UserDao;
import com.vso.model.entity.User;
import com.vso.model.service.authentication.AuthenticationService;
import com.vso.model.service.authentication.AuthenticationServiceImpl;
import com.vso.view.SystemMsgsView;

import java.util.Objects;

public class AuthController {

    private final AuthenticationService authentication;
    private final SystemMsgsView messagesView;

    public AuthController() {
        this.authentication = new AuthenticationServiceImpl();
        this.messagesView = new SystemMsgsView();
    }

    public void createUser (int age, String name, String email, String password, String repeatPassword, String avatarUrl){
        User user = UserDao.getUserBy(email);
        if (password.equals(repeatPassword)
                && user == null
                && !Objects.equals(email, "")
                && !Objects.equals(name, "")
                && !Objects.equals(password,"")) {
            authentication.registerUser(email, password, name, age, avatarUrl);
        } else {
            messagesView.showRegisterError();
        }
    }

    public void logoutUser(){
        authentication.logout();
    }
}
