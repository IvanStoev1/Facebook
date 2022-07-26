package com.vso.view.profile;

import com.vso.controller.user.UserController;
import com.vso.view.BaseScreen;
import com.vso.view.InitComponent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ProfileView extends BaseScreen {

    private final ProfileToHomeListener profileToHomeCallback;
    private final NewAvatarListener newAvatarCallback;
    private final UserController userController = new UserController();

    public ProfileView(ProfileToHomeListener profileToHomeCallback, NewAvatarListener newAvatarCallback) {
        System.out.println("PROFILE CONSTRUCTOR");
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
    public void setupComponents() {

    }

    public void setComponents(){

        getContentPanel().setLayout(getLayoutManager());
        GridBagConstraints c = new GridBagConstraints();

        JLabel lbAvatar = InitComponent.imageLabel(userController.showUserAvatar(), 200, 200, c, 0, 0, 10, 0);
        assert lbAvatar != null;
        getContentPanel().add(lbAvatar, c);

        JLabel lbUserInfo = InitComponent.txtLabel(userController.userInfo(), c, 1, 0, 10, 0);
        getContentPanel().add(lbUserInfo, c);

        JButton btnBlockUser = InitComponent.button("Block User", c, 0, 1, 10, 0);
        getContentPanel().add(btnBlockUser, c);

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

        //TODO SOMETHING ELSE
        btnBlockUser.addActionListener(new AbstractAction() {
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