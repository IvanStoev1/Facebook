package com.vso;

import com.vso.controller.AuthController;
import com.vso.model.service.authentication.AuthenticationService;
import com.vso.model.service.authentication.AuthenticationServiceImpl;
import com.vso.model.service.login.LoginSession;
import com.vso.view.AuthView;

public class Main {

    public static void main(String[] args) {

        AuthenticationService authentication = new AuthenticationServiceImpl();
        new LoginSession(authentication, new AuthController(authentication, new AuthView())).initSession();
    }
}
