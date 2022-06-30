package com.vso;

import com.vso.controller.Controller;
import com.vso.model.service.AuthenticationServiceImpl;
import com.vso.model.UserDao;
import com.vso.view.AuthView;

public class Main {

    public static void main(String[] args) {

        new Controller(new AuthenticationServiceImpl(),
                new UserDao(),
                new AuthView())
                .initializeProgram();

    }

}
