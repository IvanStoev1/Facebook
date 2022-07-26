package com.vso.model.service.changeProfileData;

import com.vso.model.dao.UserDao;
import com.vso.model.entity.User;
import com.vso.model.service.authentication.AuthenticationServiceImpl;

public class EmailReset {

    private User user;
    public EmailReset() {
        this.user = AuthenticationServiceImpl.getLoggedUser();
    }

    public boolean numbersMatch(int inputNumber) {
        return inputNumber == AuthenticationServiceImpl.getLoggedUser().getLastSentNumber();
    }

    public void reset(String email) {
        AuthenticationServiceImpl.getLoggedUser().setEmail(email);
    }
}
