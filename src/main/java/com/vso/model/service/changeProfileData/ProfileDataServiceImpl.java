package com.vso.model.service.changeprofiledata;

import com.vso.model.dao.UserDao;
import com.vso.model.service.forgottenpassword.EmailUtility;
import com.vso.model.service.forgottenpassword.EmailUtilityImpl;
import com.vso.model.service.forgottenpassword.PasswordReset;
import com.vso.model.service.forgottenpassword.PasswordResetImpl;

public class ProfileDataServiceImpl implements ProfileDataService{

    private final EmailUtility emailUtility;
    private final PasswordReset passwordReset;
    private final EmailReset emailReset;

    public ProfileDataServiceImpl(EmailReset emailReset) {
        this.emailUtility = new EmailUtilityImpl();
        this.passwordReset = new PasswordResetImpl();
        this.emailReset = emailReset;
    }

    @Override
    public void changePassword(String newPassword ){
        passwordReset.reset(newPassword);
        UserDao.setNewPassword(newPassword);
    }

    @Override
    public void changeEmail(String newEmail) {
        emailReset.reset(newEmail);
        UserDao.setNewEmail(newEmail);
    }
}
