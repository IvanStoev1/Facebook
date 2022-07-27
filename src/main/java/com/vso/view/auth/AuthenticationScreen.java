package com.vso.view.auth;

import com.vso.view.BaseScreen;
import com.vso.model.enumaration.LoginStatus;
import com.vso.model.service.authentication.AuthenticationServiceImpl;
import com.vso.view.SystemMsgsView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AuthenticationScreen extends BaseScreen {

    SystemMsgsView systemMsgsView;
    AuthenticationServiceImpl authenticationService;
    private final AuthScreenListener authCallback;
    private final ForgottenPassListener forgottenPassCallback;
    private final HomeScreenListener homeScreenCallback;

    public AuthenticationScreen(AuthScreenListener authCallback, ForgottenPassListener forgottenPassCallback, HomeScreenListener homeScreenCallback) {
        setTitle("Login Screen");
        this.authCallback = authCallback;
        this.forgottenPassCallback = forgottenPassCallback;
        this.homeScreenCallback = homeScreenCallback;
        this.systemMsgsView = new SystemMsgsView();
        this.authenticationService = new AuthenticationServiceImpl();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    protected GridBagLayout getLayoutManager() {
        return new GridBagLayout();
    }

    @Override
    protected void setupComponents() {
        getContentPanel().setLayout(getLayoutManager());

        JLabel label = new JLabel("Email");
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 50, 0, 5);
        getContentPanel().add(label, c);

        JTextField email = new JTextField(11);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.insets = new Insets(0, 5, 0, 50);
        c.gridx = 1;
        c.gridy = 0;
        getContentPanel().add(email, c);

        JLabel label1 = new JLabel("Password");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(0, 50, 0, 5);
        getContentPanel().add(label1, c);

        JTextField password = new JTextField(11);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.insets = new Insets(0, 5, 0, 50);
        c.gridx = 1;
        c.gridy = 1;
        getContentPanel().add(password, c);

        JButton login = new JButton("Login");
        login.setBackground(Color.WHITE);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.insets = new Insets(0, 5, 0, 50);
        c.gridx = 1;
        c.gridy = 4;
        getContentPanel().add(login, c);

        JButton register = new JButton("Register");
        register.setBackground(Color.WHITE);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(0, 50, 0, 5);
        getContentPanel().add(register, c);

        JButton forgottenPass = new JButton("Forgotten password");
        forgottenPass.setBackground(Color.WHITE);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 7;
        c.insets = new Insets(10, 50, 0, 5);
        getContentPanel().add(forgottenPass, c);

        login.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                LoginStatus loginStatus = authenticationService.login(email.getText(), password.getText());
                if (loginStatus == LoginStatus.LOGIN_FAILED) {
                    systemMsgsView.showLoginFail();
                } else {
                    homeScreenCallback.loginSuccessful();
                }
            }
        });

        register.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                authCallback.onRegisterSelected();
            }
        });

        forgottenPass.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                forgottenPassCallback.onForgottenPassSelected();

            }
        });
    }

    public interface AuthScreenListener {
        void onRegisterSelected();
    }
    public interface ForgottenPassListener{
        void onForgottenPassSelected();
    }
    public interface HomeScreenListener{
        void loginSuccessful();
    }

}




