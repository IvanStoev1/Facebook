package com.vso.view.profile;

import com.vso.controller.user.UserController;
import com.vso.model.entity.Photo;
import com.vso.view.BaseScreen;
import com.vso.view.InitComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LikeCommentPhotoSection extends BaseScreen {

    private final UserController userController = new UserController();
    Photo newAvatar;

    public LikeCommentPhotoSection(Photo newAvatar) {
        this.newAvatar = newAvatar;
        setSize(300, 200);
        makeVisible();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Like & Comment");
    }

    @Override
    protected GridBagLayout getLayoutManager() {
        return new GridBagLayout();
    }

    @Override
    protected void setupComponents() {
        getContentPanel().setLayout(getLayoutManager());
        GridBagConstraints c = new GridBagConstraints();

        JButton btnLike = InitComponent.button("Like", c, 0, 0,10 ,0);
        getContentPanel().add(btnLike, c);

        JButton btnComment = InitComponent.button("Comment", c, 1, 0, 10, 0);
        getContentPanel().add(btnComment, c);

        JButton btnSeeLike = InitComponent.button( "See Likes", c, 0,1, 10, 0);
        getContentPanel().add(btnSeeLike, c);

        JButton btnReadComments = InitComponent.button("Read Comments", c, 1,1, 10, 0);
        getContentPanel().add(btnReadComments, c);

        JButton btnSelectAsAvatar = InitComponent.button("Select As Avatar", c, 0,2, 10, 0);
        getContentPanel().add(btnSelectAsAvatar, c);

        btnSelectAsAvatar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                userController.setNewAvatar(newAvatar.getUrl());
                
            }
        });
    }

    public void setId(Photo newAvatar) {
        this.newAvatar = newAvatar;
    }
}
