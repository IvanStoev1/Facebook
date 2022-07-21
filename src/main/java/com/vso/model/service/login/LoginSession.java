package com.vso.model.service.login;

import com.vso.controller.AuthController;
import com.vso.model.service.authentication.AuthenticationService;

public class LoginSession {

    private AuthenticationService authenticationService;
    private AuthController authController;

    public LoginSession(AuthenticationService authenticationService, AuthController authController) {
        this.authenticationService = authenticationService;
        this.authController = authController;
    }

    public void initSession() {
        while (true) {
            authenticationService.login(authController.getTextInput(), authController.getTextInput());
            while (authenticationService.hasLoggedUser()) {
                authController.processLoggedUserOptions();
            }
        }
    }
}