package com.vso.model.service.forgottenPassword;

public interface PasswordReset {
    boolean numbersMatch(String inputNumber);

    void reset(String password);
}
