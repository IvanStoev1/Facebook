package com.vso.model.service.authentication;

import com.vso.model.constant.LoginStatus;
import com.vso.model.data.UserDao;
import com.vso.model.entity.User;

public class AuthenticationServiceImpl implements AuthenticationService {

    private User loggedUser;
    private final UserDao database;

    public AuthenticationServiceImpl() {
        this.loggedUser = null;
        this.database = new UserDao();

    }

    @Override
    public boolean registerUser(String email,String password,String name,int age) {
        if (database.userExists(email, password)) {
            return false;
        }

        User user = new User(email,password,name,age);
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
    public boolean hasLoggedUser() {
        return loggedUser != null;

    }

}
