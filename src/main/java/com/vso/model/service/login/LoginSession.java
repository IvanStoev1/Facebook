package com.vso.model.service.login;

import com.vso.controller.AuthController;
import com.vso.model.entity.User;
import com.vso.model.service.authentication.AuthenticationService;

public class LoginSession {

    private User loggedUser;
    private int loggedId;

    private AuthenticationService authenticationService;
    private AuthController authController;

    public LoginSession(AuthenticationService authenticationService, AuthController authController) {
        this.authenticationService = authenticationService;
        this.authController = authController;
    }

    public void initSession() {
        while (true) {
            authController.authenticateUser();
            while (authenticationService.hasLoggedUser()) {
                loggedUser = authenticationService.getLoggedUser();
                loggedId = loggedUser.getId();
                Login login = new Login(loggedUser);
                authController.processLoggedUserOptions();
            }
        }
    }
}