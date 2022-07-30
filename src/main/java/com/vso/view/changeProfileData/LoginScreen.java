package com.vso.view.changeprofiledata;

import com.vso.model.enumaration.LoginStatus;
import com.vso.model.service.authentication.AuthenticationService;
import com.vso.model.service.authentication.AuthenticationServiceImpl;
import com.vso.view.BaseScreen;
import com.vso.view.Navigation;

import javax.swing.*;
import java.awt.*;

public class LoginScreen extends BaseScreen {

    private final Navigation navigation;
    private final AuthenticationService authenticationService;
    private final ChangeProfileDataView profileDataView;

    public LoginScreen(Navigation navigation) {
        this.navigation = navigation;
        this.authenticationService = new AuthenticationServiceImpl();
        this.profileDataView = new ChangeProfileDataView();
    }

    @Override
    protected LayoutManager getLayoutManager() {
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

        login.addActionListener(e -> {
            LoginStatus loginStatus = authenticationService.login(email.getText(), password.getText());
            LoginStatus loginStatusInDatabase = authenticationService.login(AuthenticationServiceImpl.getLoggedUser().getEmail(),
                    AuthenticationServiceImpl.getLoggedUser().getPassword());
            if (loginStatus == loginStatusInDatabase){
                navigation.redirectToChangePasswordScreen();
            }else {
                profileDataView.showInvalidInput();
            }
        });
    }
}
