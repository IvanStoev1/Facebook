package com.vso.view.feed;

import com.vso.model.dao.PostDao;
import com.vso.model.entity.Post;
import com.vso.model.entity.User;
import com.vso.model.service.authentication.AuthenticationServiceImpl;
import com.vso.view.BaseScreen;
import com.vso.view.InitComponent;
import com.vso.view.Navigation;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewsFeedScreen extends BaseScreen {

    private final Navigation navigation;

    public NewsFeedScreen(Navigation navigation) {
        this.navigation = navigation;
    }

    @Override
    protected LayoutManager getLayoutManager() {
        return new GridBagLayout();
    }

    @Override
    protected void setupComponents() {
        getContentPanel().setLayout(new GridLayout(10, 1, 20, 15));
        getContentPanel().setBackground(new Color(104, 128, 255, 104));
        addHomeBtn();
//        PostDao.getOrderedPosts().forEach(this::drawPost);
//        PostDao.selectPostsByUserId(AuthenticationServiceImpl.getLoggedUser()).forEach(post -> drawPost(post));
    }

    private void addHomeBtn() {
        GridBagConstraints c = new GridBagConstraints();
        JButton btnOpenUpload = InitComponent.button("HOME", c, 0, 0, 50, 50);
        getContentPanel().add(btnOpenUpload, c);

        btnOpenUpload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigation.redirectFeedToHome();
            }
        });
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

//    public static void main(String[] args) {
//        User user = new User("luizasvetoslavova16@gmail.com", "1234", "Lu", 16, "ddz");
//        user.getPosts().add(new Post("Hi hi!", user));
//        AuthenticationServiceImpl.setLoggedUser(user);
//        new NewsFeedScreen(new Navigation()).makeVisible();
//    }
}