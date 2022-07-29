package com.vso.model.service.changeProfileData;

import com.vso.model.dao.UserDao;
import com.vso.model.service.authentication.AuthenticationServiceImpl;
import com.vso.model.service.forgottenPassword.EmailUtility;
import com.vso.model.service.forgottenPassword.EmailUtilityImpl;
import com.vso.model.service.forgottenPassword.PasswordReset;

public class ProfileDataServiceImpl implements ProfileDataService{

    private PasswordReset passwordReset;
    private EmailUtility emailUtility;
    private EmailReset emailReset;

    public ProfileDataServiceImpl(EmailReset emailReset) {
        this.passwordReset = new PasswordReset(AuthenticationServiceImpl.getLoggedUser());
        this.emailUtility = new EmailUtilityImpl();
        this.emailReset = emailReset;
    }


    @Override
    public void changePassword(String newPassword ){
        passwordReset.reset(newPassword);
        UserDao.setNewPassword(newPassword);
    }

    @Override
    public void changeEmail(String newEmail) {
        //int lastSentNumber = emailUtility.sendVerificationEmail(AuthenticationServiceImpl.getLoggedUser().getEmail());
       // UserDao.setLastSentNumber(lastSentNumber);
        emailReset.reset(newEmail);
        UserDao.setNewEmail(newEmail);
    }
}
