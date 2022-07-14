package com.vso.frontEnd;

import com.vso.model.entity.User;
import com.vso.model.service.authentication.AuthenticationService;
import com.vso.model.service.authentication.AuthenticationServiceImpl;
import com.vso.model.service.forgottenPassword.EmailUtilityImpl;
import com.vso.model.service.forgottenPassword.PasswordReset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class ForgottenPassScreen extends BaseScreen {
    private final ResetPassListener callback;
    private final EmailUtilityImpl emailUtility;
    private Navigation navigation;
    private final AuthenticationService authenticationService;

    public ForgottenPassScreen(Navigation navigation,ResetPassListener callback){
        this.callback = callback;
        this.navigation = navigation;
        this.authenticationService = new AuthenticationServiceImpl();
        this.emailUtility = new EmailUtilityImpl();
        getContentPanel().setBackground(Color.white);

    }

    @Override
    protected LayoutManager getLayoutManager() {
        return new GridBagLayout();
    }

    @Override
    protected void setupComponents() {
        JLabel labEmail = new JLabel("Email:");
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(0, 50, 0, 5);
        getContentPanel().add(labEmail, c);

        JTextField txtEmailField = new JTextField();
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.insets = new Insets(0, 5, 0, 50);
        c.gridx = 1;
        c.gridy = 2;
        getContentPanel().add(txtEmailField, c);

        JButton verify = new JButton("Send verification code");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.insets = new Insets(0, 100, 0, 100);
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 2;
        getContentPanel().add(verify, c);

        verify.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(authenticationService.checkIfUserExists(txtEmailField.getText())){
                    emailUtility.sendVerificationEmail(txtEmailField.getText());
                    callback.ResetPassSelected();
                }
            }
        });
    }
}

interface ResetPassListener{
    void ResetPassSelected();
}
