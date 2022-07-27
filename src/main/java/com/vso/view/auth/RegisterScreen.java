package com.vso.view.auth;

import com.vso.controller.auth.AuthController;
import com.vso.view.BaseScreen;
import com.vso.model.service.authentication.AuthenticationService;
import com.vso.model.service.authentication.AuthenticationServiceImpl;
import com.vso.view.SystemMsgsView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class RegisterScreen extends BaseScreen {

    private final RegisterViewListener registerViewCallback;
    SystemMsgsView view;
    private final AuthController controller;

    public RegisterScreen(RegisterViewListener registerViewCallback) {
        this.registerViewCallback = registerViewCallback;
        setTitle("Register Screen");
        view = new SystemMsgsView();
        this.controller = new AuthController();
    }

    @Override
    protected LayoutManager getLayoutManager() {
        return new GridBagLayout();
    }

    @Override
    protected void setupComponents() {
        JLabel labName = new JLabel("Name");
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 50, 0, 5);
        getContentPanel().add(labName, c);

        JTextField txtName = new JTextField();
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.insets = new Insets(0, 5, 0, 50);
        c.gridx = 1;
        c.gridy = 0;
        getContentPanel().add(txtName, c);

        JLabel labAge = new JLabel("Age");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(0, 50, 0, 5);
        getContentPanel().add(labAge, c);

        final JTextField txtAge = new JTextField();
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.insets = new Insets(0, 5, 0, 50);
        c.gridx = 1;
        c.gridy = 1;
        getContentPanel().add(txtAge, c);

        JLabel labEmail = new JLabel("Email:");
        c = new GridBagConstraints();
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

        JLabel labPassword = new JLabel("Password:");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(0, 50, 0, 5);
        getContentPanel().add(labPassword, c);

        JPasswordField txtPassword = new JPasswordField();
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.insets = new Insets(0, 5, 0, 50);
        c.gridx = 1;
        c.gridy = 3;
        getContentPanel().add(txtPassword, c);

        JLabel labRepeatPassword = new JLabel("Repeat Password:");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(0, 50, 0, 5);
        getContentPanel().add(labRepeatPassword, c);

        JPasswordField txtRepeatPassword = new JPasswordField();
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.insets = new Insets(0, 5, 0, 50);
        c.gridx = 1;
        c.gridy = 4;
        getContentPanel().add(txtRepeatPassword, c);

        JButton btnRegister = new JButton("Register");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.insets = new Insets(0, 100, 0, 100);
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 2;
        getContentPanel().add(btnRegister, c);

        btnRegister.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (Integer.parseInt(txtAge.getText()) < 14
                        || txtName.getText().isEmpty()
                        || txtEmailField.getText().isEmpty()){
                    view.showRegisterFail();
                } else {
                    controller.createUser(Integer.parseInt(txtAge.getText()), txtName.getText(), txtEmailField.getText(),
                            txtPassword.getText(),
                            txtRepeatPassword.getText(),
                            addDefaultAvatar());
                    registerViewCallback.onRegisterSuccessful();
                }
            }
        });
    }

    private String addDefaultAvatar() {
        String appPath = ((new File(".").
                getAbsoluteFile()).
                toString()).
                replace(".", "");
        String uploadDestination = appPath + "src\\main\\resources\\Upload";
        String fileName = "default";

        return uploadDestination + "\\" + fileName + ".png";
    }

    public interface RegisterViewListener {
        void onRegisterSuccessful();
    }
}
