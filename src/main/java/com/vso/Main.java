package com.vso;

import com.vso.controller.Controller;
import com.vso.model.service.authentication.AuthenticationServiceImpl;
import com.vso.model.data.UserDao;
import com.vso.view.AuthView;

public class Main {

    public static void main(String[] args) {

        new Controller(new AuthenticationServiceImpl(),
                new UserDao(),
                new AuthView())
                .initializeProgram();
    }
}
