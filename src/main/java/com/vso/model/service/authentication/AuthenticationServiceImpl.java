package com.vso.model.service.authentication;

import com.vso.model.enumaration.LoginStatus;
import com.vso.model.dao.UserDao;
import com.vso.model.entity.User;

import java.io.File;

public class AuthenticationServiceImpl implements AuthenticationService {
    private User loggedUser;
    private final UserDao database;

    public AuthenticationServiceImpl() {
        this.loggedUser = null;
        this.database = new UserDao();
    }

    @Override
    public boolean registerUser(String email, String password, String name, int age, String avatarUrl) {
        if (database.userExists(email)) {
            return false;
        }
        User user = new User(email, password, name, age, avatarUrl);
        UserDao.addUser(user);
        return true;
    }

    @Override
    public LoginStatus login(String email, String password) {
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
    public boolean checkIfUserExists(String email) {
        return database.userExists(email);
    }

    @Override
    public boolean hasLoggedUser() {
        return loggedUser != null;
    }

    @Override
    public User getLoggedUser() {
        return loggedUser;
    }

}
