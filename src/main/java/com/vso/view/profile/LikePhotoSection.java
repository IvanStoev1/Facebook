package com.vso.view.profile;

//import com.vso.controller.likeController.PhotoLikeController;
import com.vso.controller.user.UserController;
import com.vso.model.entity.Photo;
import com.vso.model.entity.User;
import com.vso.view.BaseScreen;
import com.vso.view.InitComponent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LikePhotoSection extends BaseScreen {

    private final UserController userController = new UserController();
//    private final PhotoLikeController photoLikeController = new PhotoLikeController();
//    private static LikePhotoResultSet likePhotoResultSet;


    public LikePhotoSection() {
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Like Photos 2");
        makeVisible();
    }

    @Override
    protected GridBagLayout getLayoutManager() {
        return new GridBagLayout();
    }

    public void setComponents(Photo newAvatar, User user, JPanel controlPanel) {

        GridBagConstraints c = new GridBagConstraints();

        JButton btnLike = InitComponent.button( " Like", c, 0, 0, 10, 0);
        //TODO + LIKE + photoLikeController.countLikes(newAvatar) +
        controlPanel.add(btnLike, c);

        JButton btnSelectAsAvatar = InitComponent.button("Select As Avatar", c, 1, 0, 0, 10);
        controlPanel.add(btnSelectAsAvatar, c);

//        LikePhotoResultSet.setComponents(1, newAvatar, getContentPanel());

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
}