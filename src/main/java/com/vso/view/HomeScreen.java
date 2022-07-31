package com.vso.view;

import com.vso.controller.auth.AuthController;
import com.vso.view.profile.MyProfileView;
import com.vso.view.search.Search;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class HomeScreen extends BaseScreen {

    private final Navigation navigation;
    private AuthController authController;

    public HomeScreen(Navigation navigation){
        this.navigation = navigation;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Home Screen");
    }

    protected LayoutManager getLayoutManager() {
        return new GridBagLayout();
    }

    protected void setupComponents() {

        getContentPanel().setLayout(getLayoutManager());
        GridBagConstraints c = new GridBagConstraints();

        JButton btnOpenUpload = InitComponent.button("Upload Photo", c, 0, 0, 50, 50);
        getContentPanel().add(btnOpenUpload, c);

        JButton btnSearchUsers = InitComponent.button("Search Users", c, 0, 1, 50, 50);
        getContentPanel().add(btnSearchUsers, c);

        JButton btnProfile = InitComponent.button("My Profile", c, 0, 2, 50, 50);
        getContentPanel().add(btnProfile, c);

        JButton btnFriendRequest = InitComponent.button("Requests", c, 0, 3, 50, 50);
        getContentPanel().add(btnFriendRequest, c);

        JButton btnLogout = InitComponent.button("Logout", c, 0, 5, 50, 50);
        getContentPanel().add(btnLogout, c);

        btnFriendRequest.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                navigation.redirectFromHomeToRequests();
            }
        });

        btnLogout.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                navigation.redirectFromHomeToLogin();
            }
        });

        btnOpenUpload.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                navigation.redirectFromHomeToUploadView();
            }
        });

        btnSearchUsers.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
                Search search = new Search(navigation);
                search.makeVisible();
            }
        });

        btnProfile.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
                MyProfileView myProfileView = new MyProfileView(navigation);
                myProfileView.setComponents();
                myProfileView.makeVisible();
            }
        });
    }
}
