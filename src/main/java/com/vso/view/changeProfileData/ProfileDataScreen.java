package com.vso.view.changeProfileData;

import com.vso.view.BaseScreen;
import com.vso.view.HomeScreen;
import com.vso.view.Navigation;
import com.vso.view.profile.MyProfileView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileDataScreen extends BaseScreen {

    private final Navigation navigation;

    public ProfileDataScreen(Navigation navigation) {
        this.navigation = navigation;
        setTitle("Settings");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    @Override
    protected LayoutManager getLayoutManager() {
        return new GridBagLayout();
    }

    @Override
    protected void setupComponents() {
        getContentPanel().setLayout(getLayoutManager());

        JButton changePassword = new JButton("Change Password");
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.insets = new Insets(0, 50, 0, 50);
        getContentPanel().add(changePassword, c);

        changePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigation.redirectToLoginScreen();
            }
        });

        JButton changeEmail = new JButton("Change Email");
        GridBagConstraints g = new GridBagConstraints();
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 0;
        g.weightx = 1;
        g.insets = new Insets(50, 50, 0, 50);
        getContentPanel().add(changeEmail, g);

        changeEmail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigation.redirectToChangeEmailScreen();
            }
        });

        JButton home = new JButton("BACK");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 2;
        g.weightx = 1;
        g.insets = new Insets(50, 50, 0, 50);
        getContentPanel().add(home, g);

        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MyProfileView myProfileView = new MyProfileView();
                myProfileView.makeVisible();
            }
        });
    }
}
