package com.vso;

import com.vso.controller.Controller;
import com.vso.model.service.AuthenticationServiceImpl;
import com.vso.model.service.CommunicationImpl;
import com.vso.model.service.UserDao;

public class Main {

    public static void main(String[] args) {

        new Controller(new AuthenticationServiceImpl(),
                new UserDao(),
                new CommunicationImpl())
                .initializeProgram();

    }

}
