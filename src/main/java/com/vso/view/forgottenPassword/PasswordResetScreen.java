package com.vso.view.forgottenPassword;

import com.vso.model.dao.UserDao;
import com.vso.model.service.authentication.AuthenticationServiceImpl;
import com.vso.model.service.changeProfileData.EmailReset;
import com.vso.model.service.changeProfileData.ProfileDataService;
import com.vso.model.service.changeProfileData.ProfileDataServiceImpl;
import com.vso.view.BaseScreen;
import com.vso.view.Message;
import com.vso.view.Navigation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordResetScreen extends BaseScreen {

    private final Navigation navigation;
    private final ProfileDataService profileDataService;

    public PasswordResetScreen(Navigation navigation) {
        this.navigation = navigation;
        this.profileDataService = new ProfileDataServiceImpl(new EmailReset());
    }

    @Override
    protected LayoutManager getLayoutManager() {
        return new GridBagLayout();
    }

    @Override
    protected void setupComponents() {
        getContentPanel().setLayout(getLayoutManager());

        JLabel instruction1 = new JLabel("New password:");
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 50, 0, 5);
        getContentPanel().add(instruction1, c);

        JTextField password1 = new JPasswordField(11);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.insets = new Insets(0, 5, 0, 50);
        c.gridx = 1;
        c.gridy = 0;
        getContentPanel().add(password1, c);

        JLabel instruction2 = new JLabel("Repeat password:");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(0, 50, 0, 5);
        getContentPanel().add(instruction2, c);

        JTextField password2 = new JPasswordField(11);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.insets = new Insets(0, 5, 0, 50);
        c.gridx = 1;
        c.gridy = 1;
        getContentPanel().add(password2, c);

        JButton submitBtn = new JButton("Submit");
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        c.ipadx = 5;
        c.ipady = 5;
        c.gridwidth = 0;
        c.insets = new Insets(70, 0, 0, 140);
        getContentPanel().add(submitBtn, c);

        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(password1.equals(password2)) {
                    UserDao.getUserBy(EmailFormScreen.getEmail()).setPassword(password1.getText());
                    new Message("Password reset successfully!");
                    AuthenticationServiceImpl.setLoggedUser(UserDao.getUserBy(EmailFormScreen.getEmail()));
                    navigation.redirectToHomeScreenFromPassReset();
                } else {
                    new Message("Passwords mismatch!");
                }
            }
        });
    }
}