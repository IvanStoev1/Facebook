package com.vso.model.service.login;

import com.vso.model.entity.User;

import java.util.Date;

public class Login {

    private User user;
    private Date date;

    public Login(User user) {
        this.user = user;
        date = new Date();
    }
}