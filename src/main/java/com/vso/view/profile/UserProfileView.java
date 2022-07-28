package com.vso.view.profile;

import com.vso.controller.friendship.FriendshipController;
import com.vso.controller.user.UserController;
import com.vso.model.entity.User;
import com.vso.model.service.authentication.AuthenticationServiceImpl;
import com.vso.model.service.block.BlockUser;
import com.vso.model.service.block.BlockUserImpl;
import com.vso.view.BaseScreen;
import com.vso.view.InitComponent;
import com.vso.view.Navigation;
import com.vso.view.search.Search;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class UserProfileView extends BaseScreen {

    private final Navigation navigation = new Navigation();
    private final UserController userController = new UserController();
    private final Search search = new Search(navigation);
    private final BlockUser blockUser = new BlockUserImpl();
    private final FriendshipController friendshipController = new FriendshipController();
    private User requested;
    private final GallerySection gallerySection = new GallerySection(requested, navigation);

    public UserProfileView(User requested) {
        this.requested = requested;
        setTitle(requested.getName());
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    public void setUser(User requested) {
        this.requested = requested;
    }

    @Override
    protected GridBagLayout getLayoutManager() {
        return new GridBagLayout();
    }

    public void setComponents() {
        User loggedUser = AuthenticationServiceImpl.getLoggedUser();

        getContentPanel().setLayout(getLayoutManager());
        GridBagConstraints c = new GridBagConstraints();

        JLabel lbAvatar = InitComponent.imageLabel(userController.showUserAvatar(requested), 200, 200, c, 0, 0, 10, 0);
        assert lbAvatar != null;
        getContentPanel().add(lbAvatar, c);

        JLabel lbUserInfo = InitComponent.txtLabel(userController.userInfo(requested), c, 1, 0, 10, 0);
        getContentPanel().add(lbUserInfo, c);

        JToggleButton btnBlockUser = InitComponent.selectButton("Block User", c, 0, 1, 10, 0);
        getContentPanel().add(btnBlockUser, c);

        if (friendshipController.isUserBlocked(loggedUser, requested)) {
            btnBlockUser.setSelected(true);
        }

        JButton btnBack = InitComponent.button("BACK", c, 0, 2, 10, 0);
        getContentPanel().add(btnBack, c);

        JButton btnDeleteAccount = InitComponent.button("DELETE ACCOUNT", c, 1, 2, 10, 0);
        getContentPanel().add(btnDeleteAccount, c);
        btnDeleteAccount.setEnabled(false);

        JButton btnUserPosts = InitComponent.button("USER POSTS", c, 2, 2, 10, 0);
        getContentPanel().add(btnUserPosts, c);

        int gridYInitial = 3;
        gallerySection.setupGallery(gridYInitial, getContentPanel(), requested); //SETUP GALLERY COMPONENTS

        gridYInitial = gallerySection.getLastYgrid(requested) + gridYInitial;
        PostSection.setupPostSection(gridYInitial, getContentPanel());

        btnBlockUser.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (btnBlockUser.isSelected()) {
                    friendshipController.blockUser(loggedUser, requested);
                    btnBlockUser.setText("BLOCKED");
                }
                friendshipController.unblockUser(loggedUser, requested);
                btnBlockUser.setText("Block User");
            }
        });


        btnBack.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
                search.makeVisible();
            }
        });
    }

    @Override
    public void setupComponents() {

    }
}