package com.vso.model.service.forgottenPassword;

import com.vso.model.dao.UserDao;
import com.vso.model.entity.User;
import com.vso.view.forgottenPassword.EmailFormScreen;

public class PasswordResetImpl implements PasswordReset {

    public PasswordResetImpl(User user) {

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