package com.vso.view.profileView;

import com.vso.view.BaseScreen;
import com.vso.view.Navigation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileView extends BaseScreen {

    private final ProfileToHomeListener profileToHomeCallback;
    private final Navigation navigation;
    public ProfileView(ProfileToHomeListener profileToHomeCallback,Navigation navigation) {
        this.profileToHomeCallback = profileToHomeCallback;
        this.navigation = navigation;
        setTitle("My Profile");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    @Override
    protected GridBagLayout getLayoutManager() {
        return new GridBagLayout();
    }

    @Override
    protected void setupComponents() {
        getContentPanel().setLayout(getLayoutManager());

        JButton btnHome = new JButton("HOME");
        GridBagConstraints c = new GridBagConstraints();
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.insets = new Insets(0, 50, 0, 50);
        c.gridx = 0;
        c.gridy = 0;
        getContentPanel().add(btnHome, c);

        JLabel lbAvatar = new JLabel("AVATAR PHOTO");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(0, 50, 0, 50);
        getContentPanel().add(lbAvatar, c);

        JLabel lbUserInfo = new JLabel("USER INFO");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(0, 50, 0, 50);
        getContentPanel().add(lbUserInfo, c);

        JLabel lbGallery = new JLabel("GALLERY");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(0, 50, 0, 50);
        getContentPanel().add(lbGallery, c);

        JLabel lbUserPosts = new JLabel("USER POSTS");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(0, 50, 0, 50);
        getContentPanel().add(lbUserPosts, c);

        JButton settingsBtn = new JButton("Settings");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.insets = new Insets(50, 50, 0, 50);
        c.gridx = 0;
        c.gridy = 0;
        getContentPanel().add(settingsBtn, c);

        settingsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigation.redirectToProfileDataScreen();
            }
        });

        btnHome.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                profileToHomeCallback.onHomeSelected();
            }
        });
    }

    public interface ProfileToHomeListener {
        void onHomeSelected();
    }
}
