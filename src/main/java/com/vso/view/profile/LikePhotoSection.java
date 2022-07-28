package com.vso.view.profile;

import com.vso.controller.likeController.PhotoLikeController;
import com.vso.controller.user.UserController;
import com.vso.model.entity.Photo;
import com.vso.model.entity.User;
import com.vso.model.service.authentication.AuthenticationServiceImpl;
import com.vso.view.BaseScreen;
import com.vso.view.InitComponent;
import com.vso.view.Navigation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LikePhotoSection extends BaseScreen {

    private final Navigation navigation;
    private final UserController userController = new UserController();
    private final PhotoLikeController photoLikeController = new PhotoLikeController();
    private User user;
    private static Photo newAvatar;

    public LikePhotoSection(Photo newAvatar, Navigation navigation, User user) {
        this.navigation = navigation;
        this.newAvatar = newAvatar;
        this.user = user;
        setSize(600, 400);
        makeVisible();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Like Photos");
    }

    @Override
    protected GridBagLayout getLayoutManager() {
        return new GridBagLayout();
    }

    protected static GridBagLayout getLayoutManagerr() {
        return new GridBagLayout();
    }

    protected void setComponents(Photo photo) {
        getContentPanel().setLayout(getLayoutManagerr());
        GridBagConstraints c = new GridBagConstraints();

        JButton btnLike = InitComponent.button(photoLikeController.countLikes(photo) + " Like", c, 0, 0, 10, 0);
        getContentPanel().add(btnLike, c);

        JButton btnSelectAsAvatar = InitComponent.button("Select As Avatar", c, 1, 0, 0, 10);
        getContentPanel().add(btnSelectAsAvatar, c);

        LikePhotoResultSet.setComponents(1, getContentPanel(), photo);

        btnSelectAsAvatar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userController.setNewAvatar(newAvatar.getUrl());

                java.awt.Window win[] = java.awt.Window.getWindows();
                for (Window window : win) {
                    window.dispose();
                }

                MyProfileView myProfile = new MyProfileView(navigation);
                myProfile.setComponents();
                myProfile.makeVisible();
            }
        });

        btnLike.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Window[] win = Window.getWindows();
                if (user == AuthenticationServiceImpl.getLoggedUser()) {

                    for (Window window : win) window.dispose();

                    MyProfileView profileView = new MyProfileView(navigation);
                    profileView.makeVisible();
                    profileView.setComponents();
                } else {

                    for (Window window : win) window.dispose();

                    UserProfileView profile = new UserProfileView(user);
                    profile.makeVisible();
                    profile.setComponents();
                }
            }
        });
    }

    @Override
    protected void setupComponents() {
    }

    public void setId(Photo newAvatar) {
        this.newAvatar = newAvatar;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}