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

public class MyProfileView extends BaseScreen {

    private final Navigation navigation;
    private static AuthController authController;
    private static final UserController userController = new UserController();
    private static DeleteAccountController deleteAccountController;
    private static final GallerySection gallerySection = new GallerySection();

    public MyProfileView(Navigation navigation) {
        this.navigation = navigation;
        setTitle("My Profile");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        System.out.println("My profile CONSTRUCTOR is set");
    }

    @Override
    protected GridBagLayout getLayoutManager() {
        return new GridBagLayout();
    }

    @Override
    protected void setupComponents() {

    }

    public void setComponents(){
        System.out.println("My profile components are set");

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

        JButton btnBack = InitComponent.button("BACK", c, 0, 2, 10, 0);
        getContentPanel().add(btnBack, c);

        JButton btnDeleteAccount = InitComponent.button("DELETE ACCOUNT", c, 1, 2, 10, 0);
        getContentPanel().add(btnDeleteAccount, c);

        JButton btnUserPosts = InitComponent.button("NEW POST", c, 2, 2, 10, 0);
        getContentPanel().add(btnUserPosts, c);

        int gridYInitial = 3;
        GallerySection.setupGallery(gridYInitial, getContentPanel(), loggedUser); //SETUP GALLERY COMPONENTS

        gridYInitial = GallerySection.getLastYgrid(loggedUser) + gridYInitial;
        PostSection.setupPostSection(gridYInitial, getContentPanel(), loggedUser);

        btnDeleteAccount.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                deleteAccountController.setDeleteAccount(loggedUser);
                authController.logoutUser();
                hideScreen();
                navigation.redirectFromProfileToLogin();
            }
        });

        btnBack.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
                navigation.redirectFromProfileToHome();
            }
        });
    }
}