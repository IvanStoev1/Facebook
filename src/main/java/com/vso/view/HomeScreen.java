package com.vso.view;

import com.vso.view.uploadPhotoView.UploadView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class HomeScreen extends BaseScreen {
    Navigation navigation;

    public HomeScreen(Navigation navigation){
        setTitle("Home Screen");
        JFrame frame = new JFrame();
        setSize(500, 500);
        setLocationRelativeTo(null);
        setupComponents();
        setVisible(false);
        this.navigation = navigation;
    }

    protected GridBagLayout getLayoutManager() {
        return new GridBagLayout();
    }

    protected void setupComponents() {
        setLayout(getLayoutManager());

        JButton btnOpenUpload = new JButton("Upload Photo");
        GridBagConstraints c = new GridBagConstraints();
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.insets = new Insets(0, 50, 0, 50);
        c.gridx = 0;
        c.gridy = 2;
        this.add(btnOpenUpload, c);

        JButton btnChangeAvatar = new JButton("Change Avatar");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.insets = new Insets(0, 50, 0, 50);
        c.gridx = 0;
        c.gridy = 3;
        this.add(btnChangeAvatar, c);

        btnOpenUpload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UploadView uploadView = null;
                try {
                    uploadView = new UploadView();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                uploadView.setVisible(true);
                HomeScreen.this.setVisible(false);
            }
        });
    }
}
