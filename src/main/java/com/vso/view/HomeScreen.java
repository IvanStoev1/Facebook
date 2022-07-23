package com.vso.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class HomeScreen extends BaseScreen {

    private final UploadViewListener uploadViewCallback;
    private final ProfileViewListener profileViewCallback;

    public HomeScreen(UploadViewListener uploadViewCallback, ProfileViewListener profileViewCallback){
        this.uploadViewCallback = uploadViewCallback;
        this.profileViewCallback = profileViewCallback;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Home Screen");
    }

    protected GridBagLayout getLayoutManager() {
        return new GridBagLayout();
    }

    protected void setupComponents() {
        getContentPanel().setLayout(getLayoutManager());
        GridBagConstraints c = new GridBagConstraints();

        JButton btnOpenUpload = InitComponent.button("Upload Photo", c, 0, 0, 50, 50);
        getContentPanel().add(btnOpenUpload, c);

        JButton btnChangeAvatar = InitComponent.button("Change Avatar", c, 0, 1, 50, 50);
        getContentPanel().add(btnChangeAvatar, c);

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
