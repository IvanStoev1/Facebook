package com.vso.frontEnd;

import com.vso.model.entity.User;
import com.vso.model.service.forgottenPassword.Email;
import com.vso.model.service.forgottenPassword.PasswordReset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ResetScreen extends BaseScreen{

    private Navigation navigation;
    private final PasswordReset passwordReset;
    User user;
    Email email;
    public ResetScreen(Navigation navigation){
        this.user = new User();
        this.passwordReset = new PasswordReset(user,email);
        this.navigation = navigation;

    }

    @Override
    protected LayoutManager getLayoutManager() {
        return new GridBagLayout();
    }

    @Override
    protected void setupComponents() {
        JLabel code = new JLabel("Verification code");
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(0, 50, 0, 5);
        getContentPanel().add(code, c);

        JTextField verificationCode = new JTextField();
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.insets = new Insets(0, 5, 0, 50);
        c.gridx = 1;
        c.gridy = 2;
        getContentPanel().add(verificationCode, c);

        JLabel newPassword = new JLabel("New password");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(0, 50, 0, 5);
        getContentPanel().add(newPassword, c);

        JTextField newPasswordTxt = new JTextField();
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.insets = new Insets(0, 5, 0, 50);
        c.gridx = 1;
        c.gridy = 3;
        getContentPanel().add(newPasswordTxt, c);

        JButton verify = new JButton("Reset password");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.insets = new Insets(0, 100, 0, 100);
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        getContentPanel().add(verify, c);

        verify.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passwordReset.reset(verificationCode.getText(), newPasswordTxt.getText());
            }
        });
    }
}
