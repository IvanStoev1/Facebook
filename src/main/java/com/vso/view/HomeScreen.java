package com.vso.view;

import com.vso.controller.userController.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class HomeScreen extends BaseScreen {

    private final UploadViewListener uploadViewCallback;
    private final ProfileViewListener profileViewCallback;

    public HomeScreen(UploadViewListener uploadViewCallback, ProfileViewListener profileViewCallback){
        System.out.println("home constructor");
        this.uploadViewCallback = uploadViewCallback;
        this.profileViewCallback = profileViewCallback;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Home Screen");
    }

    protected GridBagLayout getLayoutManager() {
        return new GridBagLayout();
    }

    protected void setupComponents() {
        System.out.println("home SETUP COMPONENTS");
        getContentPanel().setLayout(getLayoutManager());
        GridBagConstraints c = new GridBagConstraints();

        JButton btnOpenUpload = InitComponent.button("Upload Photo", c, 0, 0, 50, 50);
        getContentPanel().add(btnOpenUpload, c);

        JButton btnSearchUsers = InitComponent.button("Search Users", c, 0, 1, 50, 50);
        getContentPanel().add(btnSearchUsers, c);

        JButton btnProfile = InitComponent.button("My Profile", c, 0, 2, 50, 50);
        getContentPanel().add(btnProfile, c);

        btnOpenUpload.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                uploadViewCallback.onUploadSelected();
            }
        });

        btnProfile.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new UserController();
                profileViewCallback.onProfileSelected();
            }
        });
    }

    public interface UploadViewListener {
        void onUploadSelected();
    }

    public interface ProfileViewListener {
        void onProfileSelected();
    }
}
