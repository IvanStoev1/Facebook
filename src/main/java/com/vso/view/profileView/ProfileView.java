package com.vso.view.profileView;

import com.vso.controller.userController.UserController;
import com.vso.controller.userController.UserControllerImpl;
import com.vso.model.entity.User;
import com.vso.model.service.authentication.AuthenticationServiceImpl;
import com.vso.view.BaseScreen;
import com.vso.view.InitComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ProfileView extends BaseScreen {

    private final ProfileToHomeListener profileToHomeCallback;
    private final NewAvatarListener newAvatarCallback;
    private static final UserController userController = new UserControllerImpl();

    public ProfileView(ProfileToHomeListener profileToHomeCallback, NewAvatarListener newAvatarCallback) {
        this.profileToHomeCallback = profileToHomeCallback;
        this.newAvatarCallback = newAvatarCallback;
        setTitle("My Profile");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    @Override
    protected GridBagLayout getLayoutManager() {
        return new GridBagLayout();
    }

    @Override
    protected void setupComponents() {
        User loggedUser = userController.getLoggedUser();
        getContentPanel().setLayout(getLayoutManager());
        GridBagConstraints c = new GridBagConstraints();
        //TODO Change the way user is passed
        JLabel lbAvatar = InitComponent.imageLabel(userController.showUserAvatar(loggedUser), 200, 200, c, 0, 0, 10, 0);
        assert lbAvatar != null;
        getContentPanel().add(lbAvatar, c);
        //TODO Change the way user is passed
        JLabel lbUserInfo = InitComponent.txtLabel("Info", c, 1, 0, 10, 0);
        getContentPanel().add(lbUserInfo, c);

        JButton btnChangeAvatar = InitComponent.button("Change Avatar", c, 0, 1, 10, 0);
        getContentPanel().add(btnChangeAvatar, c);

        JButton btnHome = InitComponent.button("HOME", c, 0, 2, 10, 0);
        getContentPanel().add(btnHome, c);

        JButton btnReportUser = InitComponent.button("Report", c, 1, 2, 10, 0);
        getContentPanel().add(btnReportUser, c);

        JButton btnUserPosts = InitComponent.button("USER POSTS", c, 2, 2, 10, 0);
        getContentPanel().add(btnUserPosts, c);

        int gridYInitial = 3;
        GallerySection.setupGallery(gridYInitial, getContentPanel()); //SETUP GALLERY COMPONENTS

        gridYInitial = GallerySection.getLastYgrid() + gridYInitial;
        PostSection.setupPostSection(gridYInitial, getContentPanel());


        btnChangeAvatar.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                newAvatarCallback.onNewAvatarSelected();
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

    public interface NewAvatarListener {
        void onNewAvatarSelected();
    }
}
