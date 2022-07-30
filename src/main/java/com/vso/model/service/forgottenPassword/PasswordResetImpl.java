package com.vso.model.service.forgottenpassword;

import com.vso.model.dao.UserDao;
import com.vso.view.forgottenpassword.EmailFormScreen;

public class PasswordResetImpl implements PasswordReset {

    public PasswordResetImpl() {

    }

    @Override
    public boolean numbersMatch(String inputNumber) {
        return inputNumber.equals(String.valueOf(UserDao.getUserBy(EmailFormScreen.getEmail()).getLastSentNumber())) ;
    }

    @Override
    public void reset(String password) {
        UserDao.getUserBy(EmailFormScreen.getEmail()).setPassword(password);
    }
}