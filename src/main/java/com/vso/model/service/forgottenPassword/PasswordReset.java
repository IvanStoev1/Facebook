package com.vso.model.service.forgottenPassword;

import com.vso.model.dao.UserDao;
import com.vso.model.entity.User;
import com.vso.model.service.authentication.AuthenticationServiceImpl;
import com.vso.view.forgottenPassword.EmailFormScreen;

public class PasswordReset {

    public PasswordReset(User user) {

    }

    public boolean numbersMatch(String inputNumber) {
        return inputNumber.equals(String.valueOf(UserDao.getUserBy(EmailFormScreen.getEmail()).getLastSentNumber())) ;
    }

    public void reset(String password) {
        UserDao.getUserBy(EmailFormScreen.getEmail()).setPassword(password);
    }
}