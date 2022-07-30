package com.vso.view.forgottenpassword;

import com.vso.model.service.forgottenpassword.EmailUtilityImpl;
import com.vso.model.service.forgottenpassword.EmailValidatorImpl;
import com.vso.view.BaseScreen;
import com.vso.view.Message;
import com.vso.view.Navigation;
import com.vso.view.auth.AuthenticationScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmailFormScreen extends BaseScreen {

    private static String email;
    private final Navigation navigation;

    public EmailFormScreen(Navigation navigation) {
        this.setTitle("Forgot password?");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.navigation = navigation;
    }

    @Override
    protected LayoutManager getLayoutManager() {
        return new GridBagLayout();
    }

    @Override
    protected void setupComponents() {
        getContentPanel().setLayout(getLayoutManager());

        JLabel label = new JLabel("E-mail for the confirmation number: ");
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 50, 0, 5);
        getContentPanel().add(label, c);

        JTextField emailTf = new JTextField(11);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.insets = new Insets(0, 5, 0, 50);
        c.gridx = 1;
        c.gridy = 0;
        getContentPanel().add(emailTf, c);

        JButton submitBtn = new JButton("Submit");
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        c.ipadx = 2;
        c.ipady = 2;
        c.gridwidth = 0;
        c.insets = new Insets(5, 0, 0, 0);
        getContentPanel().add(submitBtn, c);

        JButton btnBack = new JButton("Back");
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 2;
        c.ipadx = 2;
        c.ipady = 2;
        c.gridwidth = 0;
        c.insets = new Insets(5, 0, 0, 0);
        getContentPanel().add(btnBack, c);

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideScreen();
                AuthenticationScreen login = new AuthenticationScreen();
                login.makeVisible();
            }
        });

        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                email = emailTf.getText();

                if (new EmailValidatorImpl().isEmailValid(email)) {
                    new EmailUtilityImpl().sendVerificationEmail(email);
                    new Message("Email sent!");
                    navigation.redirectToDigitConformation();
                } else {
                    new Message("Invalid email!");
                }
            }
        });
    }

    public static String getEmail() {
        return email;
    }
}
