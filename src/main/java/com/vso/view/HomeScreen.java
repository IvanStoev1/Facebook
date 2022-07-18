package com.vso.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class HomeScreen extends BaseScreen {

    private final UploadViewListener uploadViewCallback;
    private final AvatarViewListener avatarViewListener;
    private final ProfileViewListener profileViewCallback;

    public HomeScreen(UploadViewListener uploadViewCallback, AvatarViewListener avatarViewListener, ProfileViewListener profileViewCallback){
        this.avatarViewListener = avatarViewListener;
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

        JButton btnOpenUpload = new JButton("Upload Photo");
        GridBagConstraints c = new GridBagConstraints();
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.insets = new Insets(0, 50, 0, 50);
        c.gridx = 0;
        c.gridy = 0;
        getContentPanel().add(btnOpenUpload, c);

        JButton btnChangeAvatar = new JButton("Change Avatar");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.insets = new Insets(0, 50, 0, 50);
        c.gridx = 0;
        c.gridy = 1;
        getContentPanel().add(btnChangeAvatar, c);

        JButton btnProfile = new JButton("My Profile");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.insets = new Insets(0, 50, 0, 50);
        c.gridx = 0;
        c.gridy = 2;
        getContentPanel().add(btnProfile, c);

        btnOpenUpload.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                uploadViewCallback.onUploadSelected();
            }
        });

        btnChangeAvatar.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                avatarViewListener.onAvatarSelected();
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

    public interface AvatarViewListener {
        void onAvatarSelected();
    }

    public interface ProfileViewListener {
        void onProfileSelected();
    }
}
