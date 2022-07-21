package com.vso.model.service.authentication;

import com.vso.model.enumaration.LoginStatus;
import com.vso.model.data.UserDao;
import com.vso.model.entity.User;

public class AuthenticationServiceImpl implements AuthenticationService {

    private static User loggedUser;
    private final UserDao database;

    public AuthenticationServiceImpl() {
        this.database = new UserDao();
    }

    @Override
    public boolean registerUser(String email, String password, String name, int age) {
        if (database.userExists(email)) {
            return false;
        }
        User user = new User(email, password, name, age);
        UserDao.addUser(user);
        return true;
    }

    @Override
    public LoginStatus login(String email, String password) {
        User user = database.getUserBy(email);
        if (user != null && user.getPassword().equals(password)) {
            loggedUser = user;
            return LoginStatus.SUCCESS_USER;
        }
        return LoginStatus.LOGIN_FAILED;
    }

    @Override
    public void logout() {
        loggedUser = null;
    }

    @Override
    public boolean checkIfUserExists(String email) {
        return database.userExists(email);
    }

    @Override
    public boolean hasLoggedUser() {
        return loggedUser != null;
    }

    public static User getLoggedUser() {
        return loggedUser;
    }

    public UserDao getDatabase() {
        return database;
    }
}