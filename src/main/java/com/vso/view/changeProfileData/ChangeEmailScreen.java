package com.vso.view.changeProfileData;

import com.vso.model.dao.UserDao;
import com.vso.model.service.authentication.AuthenticationServiceImpl;
import com.vso.model.service.changeProfileData.EmailReset;
import com.vso.model.service.changeProfileData.ProfileDataService;
import com.vso.model.service.changeProfileData.ProfileDataServiceImpl;
import com.vso.model.service.forgottenPassword.EmailUtilityImpl;
import com.vso.model.service.forgottenPassword.EmailValidator;
import com.vso.view.BaseScreen;
import com.vso.view.Navigation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeEmailScreen extends BaseScreen {

    private final Navigation navigation;
    private final ProfileDataService profileDataService;
    private final EmailValidator emailValidator;
    public ChangeEmailScreen(Navigation navigation) {
        this.navigation = navigation;
        this.profileDataService = new ProfileDataServiceImpl(new EmailReset());
        this.emailValidator = new EmailValidator();
    }

    @Override
    protected LayoutManager getLayoutManager() {
        return new GridBagLayout();
    }

    @Override
    protected void setupComponents() {
        getContentPanel().setLayout(getLayoutManager());
        getContentPanel().setBackground(Color.WHITE);
        JLabel instruction1 = new JLabel("Your new email:");
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 70, 0, 70);
        getContentPanel().add(instruction1, c);


        JTextField newEmail = new JTextField();
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.insets = new Insets(0, 0, 0, 70);
        c.gridx = 1;
        c.gridy = 0;
        getContentPanel().add(newEmail, c);


        JButton setEmailBtn = new JButton("Set new Email");
        setEmailBtn.setBackground(Color.WHITE);
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        c.ipadx = 5;
        c.ipady = 5;
        c.gridwidth = 0;
        c.insets = new Insets(0, 0, 0, 70);
        getContentPanel().add(setEmailBtn, c);

        setEmailBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(emailValidator.isEmailValid(newEmail.getText())){
                    new EmailUtilityImpl().sendVerificationEmail(AuthenticationServiceImpl.getLoggedUser().getEmail());
                    profileDataService.changeEmail(newEmail.getText());
                    navigation.redirectToDigitConformation();
                }

            }
        });
    }
}
