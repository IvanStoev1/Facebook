package com.vso.view.forgottenPassword;

import com.vso.model.service.authentication.AuthenticationServiceImpl;
import com.vso.model.service.forgottenPassword.EmailUtilityImpl;
import com.vso.model.service.forgottenPassword.EmailValidator;
import com.vso.view.BaseScreen;
import com.vso.view.Message;
import com.vso.view.Navigation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmailFormScreen extends BaseScreen {

    private final Navigation navigation;
    private static String email;

    public EmailFormScreen(Navigation navigation) {
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

        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                email = emailTf.getText();

                if (new EmailValidator().isEmailValid(email)) {
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
