package com.vso.model.service.changeprofiledata;

public interface EmailReset {

    boolean numbersMatch(String inputNumber);

    void reset(String email);
}
