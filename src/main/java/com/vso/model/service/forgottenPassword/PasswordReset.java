package com.vso.model.service.forgottenPassword;

import com.vso.model.entity.User;

public class PasswordReset {
    private User user;

    public PasswordReset(User user) {
        this.user = user;
    }

    public boolean numbersMatch(int inputNumber) {
        return inputNumber == user.getLastSentNumber();
    }

    public void reset(String password) {
        user.setPassword(password);
    }
}