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

    private Navigation navigation;
    private final UserController userController = new UserController();
    private final PhotoLikeController photoLikeController = new PhotoLikeController();
    private LikePhotoResultSet likePhotoResultSet;
    private User user;
    private Photo newAvatar;

    public LikePhotoSection() {
        this.navigation = navigation;
        this.newAvatar = newAvatar;
        this.user = user;
        this.likePhotoResultSet = new LikePhotoResultSet();
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Like Photos 2");
        makeVisible();
    }

    @Override
    protected GridBagLayout getLayoutManager() {
        return new GridBagLayout();
    }


    public static void setComponents(Photo newAvatar, User user) {

        GridBagConstraints c = new GridBagConstraints();

        JButton btnLike = InitComponent.button( " Like", c, 0, 0, 10, 0);
        //TODO + LIKE + photoLikeController.countLikes(newAvatar) +
        getContentPanel().add(btnLike, c);

        JButton btnSelectAsAvatar = InitComponent.button("Select As Avatar", c, 1, 0, 0, 10);
        getContentPanel().add(btnSelectAsAvatar, c);

        //likePhotoResultSet.setComponents(1, newAvatar);

        btnSelectAsAvatar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                userController.setNewAvatar(newAvatar.getUrl());
//                Window[] win = Window.getWindows();
//                for (Window window : win) window.dispose();
//                MyProfileView profileView = new MyProfileView(navigation);
//                profileView.setComponents();
//                profileView.makeVisible();
            }
        });

        btnLike.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO................................
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

    public void setNavigation(Navigation navigation){
        this.navigation = navigation;
    }
}