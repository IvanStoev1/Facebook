package com.vso.model.service;

import com.vso.model.entity.User;

public class AuthenticationImpl implements Authentication{

    private User loggedUser;
    private final UserDao database;

    public AuthenticationImpl() {
        this.loggedUser = null;
        this.database = new UserDao();

    }


    @Override
    public boolean registerUser(String email,String password) {
        if (database.userExists(email, password)) {
            return false;
        }

        User user = new User();
        UserDao.addUser(user);
        return true;

    }

    @Override
    public LoginStatus login(String email,String password) {
        User user = database.getObject(email);
        if (user != null && user.getPassword().equals(password)) {
            loggedUser = user;
            return LoginStatus.SUCCESS_USER;
        }

        return LoginStatus.LOGIN_FAILED;
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
