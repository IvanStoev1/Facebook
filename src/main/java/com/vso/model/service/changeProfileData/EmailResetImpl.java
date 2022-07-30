package com.vso.model.service.changeprofiledata;

import com.vso.model.dao.UserDao;
import com.vso.model.service.authentication.AuthenticationServiceImpl;

public class EmailResetImpl implements EmailReset {

    public EmailResetImpl() {

    }

    @Override
    public boolean numbersMatch(String inputNumber) {
        return inputNumber.equals(String.valueOf(UserDao.getLastSendNumber(AuthenticationServiceImpl.getLoggedUser()))) ;
    }

    @Override
    public void reset(String email) {
        AuthenticationServiceImpl.getLoggedUser().setEmail(email);
    }
}
