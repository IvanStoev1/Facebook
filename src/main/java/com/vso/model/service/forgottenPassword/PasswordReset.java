package com.vso.model.service.forgottenpassword;

public interface PasswordReset {
    boolean numbersMatch(String inputNumber);

    void reset(String password);
}
