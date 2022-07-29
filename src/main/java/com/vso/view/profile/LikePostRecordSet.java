package com.vso.view.profile;

import com.vso.controller.likeController.PhotoLikeController;
import com.vso.model.entity.Like;
import com.vso.model.entity.Likephoto;
import com.vso.model.entity.Post;
import com.vso.view.BaseScreen;
import com.vso.view.InitComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.stream.Collectors;

public class LikePostRecordSet extends BaseScreen {

    private static final PhotoLikeController photoLikeController = new PhotoLikeController();

    public LikePostRecordSet() {
    }

    @Override
    protected GridBagLayout getLayoutManager() {
        return new GridBagLayout();
    }

//    public static void setComponents(int gridYInitial, JPanel controlPanel, Post photo){
//        try {
//            int counter = 0;
//            int gridXInitial = 0;
//
//            //TODO --- BACKEND LIST OF POSTS -------------------------------------
//            for (Likephoto like : photoLikeController.likesForThisPic(post)) {
//
//                GridBagConstraints c = new GridBagConstraints();
//                counter++;
//
//                JLabel lbPhoto = InitComponent.imageLabel(like.getUser().getAvatarUrl(), 60, 60, c, gridXInitial, gridYInitial, 10, 0);
//                assert lbPhoto != null;
//                lbPhoto.setPreferredSize(new Dimension(300, 80));
//                lbPhoto.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.blue));
//                controlPanel.add(lbPhoto, c);
//
//                JLabel lbUserName = InitComponent.txtLabel(like.getUser().getName(), c, gridXInitial+1, gridYInitial, 0, 0);
//                lbUserName.setPreferredSize(new Dimension(300, 80));
//                lbUserName.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.blue));
//                controlPanel.add(lbUserName, c);
//
//                if (counter == 1) {
//                    counter = 0;
//                    gridYInitial++;
//                    gridXInitial = 0;
//                } else {
//                    gridXInitial++;
//                }
//
//                lbPhoto.addMouseListener(new MouseAdapter() {
//                    @Override
//                    public void mouseClicked(MouseEvent e) {
//                        //TODO OPEN USER PROFILE
//                    }
//                });
//            }
//        } catch (NullPointerException ignored) {
//
//        }
//    }

//TODO LIKES..................................................STREAM
//    public static List<Like> likesForThisPic(Post post){
//        return LikeDb.likes()
//                .stream()
//                .filter(l -> l.getPost().getId() == post.getId())
//                .collect(Collectors.toList());
//    }

    @Override
    protected void setupComponents() {

    }
}
