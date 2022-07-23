package com.vso.view.profileView;

import com.vso.model.entity.Photo;
import com.vso.view.BaseScreen;
import com.vso.view.InitComponent;

import javax.swing.*;
import java.awt.*;

public class LikeAndCommentSection extends BaseScreen {

    public LikeAndCommentSection() {
        setSize(300, 200);
        makeVisible();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Like & Comment");
    }

    private int photoId(Photo photo){
        return photo.getId();
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

        JButton btnSeeLike = InitComponent.button(numberOfLikes() + "See Likes", c, 0,1, 10, 0);
        getContentPanel().add(btnSeeLike, c);

        JButton btnReadComments = InitComponent.button("Read Comments", c, 1,1, 10, 0);
        getContentPanel().add(btnReadComments, c);

        JButton btnSelectAsAvatar = InitComponent.button("Select As Avatar", c, 0,2, 10, 0);
        getContentPanel().add(btnSelectAsAvatar, c);

        JLabel lbPhotoId = InitComponent.txtLabel("Photo ID:", c, 1,2, 10, 0);
        getContentPanel().add(lbPhotoId, c);
    }

    //TODO change it with result List from the DB;
    private int numberOfLikes(){
        return 153;
    }
}
