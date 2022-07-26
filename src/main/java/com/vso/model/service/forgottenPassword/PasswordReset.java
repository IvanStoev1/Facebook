package com.vso.model.service.forgottenPassword;

import com.vso.model.entity.User;
import com.vso.model.service.authentication.AuthenticationServiceImpl;

public class PasswordReset {
    private User user;

    public PasswordReset(User user) {
        this.user = user;
    }

    public boolean numbersMatch(int inputNumber) {
        return inputNumber == user.getLastSentNumber();
    }

    public void reset(String password) {
        AuthenticationServiceImpl.getLoggedUser().setPassword(password);
    }
}