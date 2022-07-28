package com.vso.model.service.changeProfileData;

import com.vso.model.dao.UserDao;
import com.vso.model.entity.User;
import com.vso.model.service.authentication.AuthenticationServiceImpl;
import com.vso.view.forgottenPassword.EmailFormScreen;

public class EmailReset {

    public EmailReset() {

    }

    public boolean numbersMatch(String inputNumber) {
        return inputNumber.equals(String.valueOf(UserDao.getLastSendNumber(AuthenticationServiceImpl.getLoggedUser()))) ;
    }

    public void reset(String email) {
        AuthenticationServiceImpl.getLoggedUser().setEmail(email);
    }
}
