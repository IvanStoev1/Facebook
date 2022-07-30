package com.vso.view.profile;

import com.vso.controller.auth.AuthController;
import com.vso.controller.deleteaccount.DeleteAccountController;
import com.vso.controller.friendship.FriendshipController;
import com.vso.controller.user.UserController;
import com.vso.model.entity.User;
import com.vso.model.service.authentication.AuthenticationServiceImpl;
import com.vso.view.BaseScreen;
import com.vso.view.InitComponent;
import com.vso.view.Navigation;
import com.vso.view.search.Search;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class UserProfile extends BaseScreen {

    private static final UserController userController = new UserController();
    private static final DeleteAccountController deleteAccountController = new DeleteAccountController();
    private static final GallerySection gallerySection = new GallerySection();
    private static final FriendshipController friendship = new FriendshipController();
    private static final Search search = new Search();
    private static AuthController authController;
    private Navigation navigation;

    public UserProfile(Navigation navigation) {
        this.navigation = navigation;
        setTitle("User");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    public UserProfile(User requested) {
        setTitle(requested.getName());
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    @Override
    protected GridBagLayout getLayoutManager() {
        return new GridBagLayout();
    }

    @Override
    protected void setupComponents() {

    }

    public void setComponents(User requested) {

        getContentPanel().setLayout(getLayoutManager());
        GridBagConstraints c = new GridBagConstraints();

        User loggedUser = AuthenticationServiceImpl.getLoggedUser();

        System.out.println("is user blocked: " + friendship.isUserBlocked(loggedUser, requested));
        JLabel lbAvatar = InitComponent.imageLabel(userController.showUserAvatar(requested), 200, 200, c, 0, 0, 10, 0);
        assert lbAvatar != null;
        getContentPanel().add(lbAvatar, c);

        JLabel lbUserInfo = InitComponent.txtLabel(userController.userInfo(requested), c, 1, 0, 10, 0);
        getContentPanel().add(lbUserInfo, c);

        JToggleButton btnBlockUser = InitComponent.selectButton("Block User", c, 0, 1, 10, 0);
        getContentPanel().add(btnBlockUser, c);

        if (friendship.isUserBlocked(loggedUser, requested)) {
            btnBlockUser.setSelected(true);
        }

        JButton btnBack = InitComponent.button("HOME", c, 0, 2, 10, 0);
        getContentPanel().add(btnBack, c);

        JButton btnDeleteAccount = InitComponent.button("DELETE ACCOUNT", c, 1, 2, 10, 0);
        getContentPanel().add(btnDeleteAccount, c);
        btnDeleteAccount.setEnabled(false);

        JButton btnUserPosts = InitComponent.button("NEW POST", c, 2, 2, 10, 0);
        getContentPanel().add(btnUserPosts, c);

        int gridYInitial = 3;
        GallerySection.setupGallery(gridYInitial, getContentPanel(), loggedUser); //SETUP GALLERY COMPONENTS

        gridYInitial = GallerySection.getLastYgrid(loggedUser) + gridYInitial;
        PostSection.setupPostSection(gridYInitial, getContentPanel(), loggedUser);

        btnBlockUser.addActionListener(new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (btnBlockUser.isSelected()) {
                    friendship.blockUser(loggedUser, requested);
                    btnBlockUser.setText("BLOCKED");
                }
                friendship.unblockUser(loggedUser, requested);
                btnBlockUser.setText("Block User");
            }
        });

        btnBack.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Window[] win = Window.getWindows();
                for (Window window : win) window.dispose();
                search.makeVisible();
            }
        });
    }
}
