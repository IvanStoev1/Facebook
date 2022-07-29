package com.vso.view.profile;

import com.vso.controller.auth.AuthController;
import com.vso.controller.deleteaccount.DeleteAccountController;
import com.vso.controller.user.UserController;
import com.vso.model.entity.User;
import com.vso.model.service.authentication.AuthenticationServiceImpl;
import com.vso.view.BaseScreen;
import com.vso.view.InitComponent;
import com.vso.view.Navigation;
import com.vso.view.deletedView.DeletedScreen;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyProfileView extends BaseScreen {

    private final ProfileToHomeListener profileToHomeCallback;
    private final AuthController authController = new AuthController();
    private final UserController userController = new UserController();
    private final Navigation navigation;
    private final DeleteAccountController deleteAccountController = new DeleteAccountController();

    public MyProfileView(ProfileToHomeListener profileToHomeCallback, Navigation navigation) {
        this.profileToHomeCallback = profileToHomeCallback;
        setTitle("My Profile");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.navigation = navigation;
    }

    @Override
    protected GridBagLayout getLayoutManager() {
        return new GridBagLayout();
    }

    @Override
    public void setupComponents() {

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

        JButton btnHome = InitComponent.button("HOME", c, 0, 2, 10, 0);
        getContentPanel().add(btnHome, c);

        JButton btnDeleteAccount = InitComponent.button("DELETE ACCOUNT", c, 1, 2, 10, 0);
        getContentPanel().add(btnDeleteAccount, c);

        JButton btnUserPosts = InitComponent.button("USER POSTS", c, 2, 2, 10, 0);
        getContentPanel().add(btnUserPosts, c);

        JButton settingsBtn = InitComponent.button("Settings", c, 3, 2, 10, 0);
        getContentPanel().add(settingsBtn, c);


        int gridYInitial = 3;
        GallerySection.setupGallery(gridYInitial, getContentPanel(), loggedUser); //SETUP GALLERY COMPONENTS

        gridYInitial = GallerySection.getLastYgrid(loggedUser) + gridYInitial;
        PostSection.setupPostSection(gridYInitial, getContentPanel());

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
                authController.logoutUser();
                hideScreen();
                DeletedScreen deletedScreen = new DeletedScreen();
                deletedScreen.setComponents();
                deletedScreen.setVisible(true);
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
