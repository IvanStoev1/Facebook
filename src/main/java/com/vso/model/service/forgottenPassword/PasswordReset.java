package com.vso.model.service.forgottenPassword;

import com.vso.model.entity.User;
import com.vso.view.PasswordResetView;

public class PasswordReset {

    private User user;
    private Email email;
    private PasswordResetView view;

    public PasswordReset(User user, Email email, PasswordResetView view) {
        this.user = user;
        this.email = email;
        this.view = view;
    }

    public void reset(String number, String password) {
        if(number.equals(email.getVerificationNumber())) {
            user.setPassword(password);
            view.approveReset();
        } else {
            view.declineReset();
        }
    }
}
