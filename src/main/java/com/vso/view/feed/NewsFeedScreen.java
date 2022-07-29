package com.vso.view.feed;

import com.vso.model.dao.PostDao;
import com.vso.model.entity.Post;
import com.vso.view.BaseScreen;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class NewsFeedScreen extends BaseScreen {

    @Override
    protected LayoutManager getLayoutManager() {
        return new GridBagLayout();
    }

    @Override
    protected void setupComponents() {
        getContentPanel().setLayout(new GridLayout(10, 1, 20, 15));
        getContentPanel().setBackground(new Color(104, 128, 255, 104));
        PostDao.getOrderedPosts().forEach(this::drawPost);
    }

    private void drawPost(Post post) {
        JLabel postVisual = new JLabel("<html>" + post.getUser().getName() + ": " + post.getDate().toString()
                + "<br/>" + post.getText() + "<br/>" +
                post.getLikes().size() + " likes, " +
                post.getComments().size() + " comments" +
                "</html>", SwingConstants.CENTER);
        postVisual.setForeground(Color.BLACK);
        postVisual.setBorder(new LineBorder(Color.BLACK));
        postVisual.setFont(new Font(Font.DIALOG, Font.PLAIN, 19));
        postVisual.setOpaque(true);
        postVisual.setBackground(new Color(208, 226, 255));
        getContentPanel().add(postVisual);
    }
}