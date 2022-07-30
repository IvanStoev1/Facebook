package com.vso.view.profile;

import com.vso.controller.auth.AuthController;
import com.vso.controller.deleteaccount.DeleteAccountController;
import com.vso.controller.user.UserController;
import com.vso.model.entity.User;
import com.vso.model.service.authentication.AuthenticationServiceImpl;
import com.vso.view.BaseScreen;
import com.vso.view.InitComponent;
import com.vso.view.Navigation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyProfileView extends BaseScreen {

    private static final UserController userController = new UserController();
    private static final GallerySection gallerySection = new GallerySection();
    private static DeleteAccountController deleteAccountController = new DeleteAccountController();
    private static AuthController authController;
    private Navigation navigation;

    public MyProfileView(Navigation navigation) {
        this.navigation = navigation;
        setTitle("My Profile");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        System.out.println("My profile CONSTRUCTOR is set");
    }

    public MyProfileView() {
    }

    @Override
    protected GridBagLayout getLayoutManager() {
        return new GridBagLayout();
    }

    @Override
    protected void setupComponents() {

    }

    public void setComponents() {

        getContentPanel().setLayout(getLayoutManager());
        GridBagConstraints c = new GridBagConstraints();

        User loggedUser = AuthenticationServiceImpl.getLoggedUser();

        JLabel lbAvatar = InitComponent.imageLabel(userController.showUserAvatar(loggedUser), 200, 200, c, 0, 0, 10, 0);
        assert lbAvatar != null;
        getContentPanel().add(lbAvatar, c);

        JLabel lbUserInfo = InitComponent.txtLabel(userController.userInfo(loggedUser), c, 1, 0, 10, 0);
        getContentPanel().add(lbUserInfo, c);

        JToggleButton btnBlockUser = InitComponent.selectButton("Block User", c, 0, 1, 10, 0);
        getContentPanel().add(btnBlockUser, c);
        btnBlockUser.setEnabled(false);

        JButton btnBack = InitComponent.button("HOME", c, 0, 2, 10, 0);
        getContentPanel().add(btnBack, c);

        JButton btnDeleteAccount = InitComponent.button("DELETE ACCOUNT", c, 1, 2, 10, 0);
        getContentPanel().add(btnDeleteAccount, c);

        JButton btnUserPosts = InitComponent.button("NEW POST", c, 2, 2, 10, 0);
        getContentPanel().add(btnUserPosts, c);

        JButton settingsBtn = InitComponent.button("Settings", c, 3, 2, 10, 0);
        getContentPanel().add(settingsBtn, c);


        int gridYInitial = 3;
        GallerySection.setupGallery(gridYInitial, getContentPanel(), loggedUser); //SETUP GALLERY COMPONENTS

        gridYInitial = GallerySection.getLastYgrid(loggedUser) + gridYInitial;
        PostSection.setupPostSection(gridYInitial, getContentPanel(), loggedUser);

        settingsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigation.redirectToProfileDataScreen();
            }
        });

        btnDeleteAccount.addActionListener(new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                deleteAccountController.setDeleteAccount(loggedUser);
                System.out.println(loggedUser.getName() + " " + loggedUser.getProfileStatus());
                dispose();
                navigation.redirectFromProfileToLogin();
            }
        });

        btnBack.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Window[] win = Window.getWindows();
                for (Window window : win) window.dispose();
                navigation.redirectFromProfileToHome();
            }
        });
    }
}
