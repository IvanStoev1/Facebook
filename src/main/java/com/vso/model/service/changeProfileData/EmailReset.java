package com.vso.model.service.changeProfileData;

public interface EmailReset {
    boolean numbersMatch(String inputNumber);

    void reset(String email);
}
