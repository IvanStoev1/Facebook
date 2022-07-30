package com.vso.view.profile;

import com.vso.controller.post.PostController;
import com.vso.controller.user.UserController;
import com.vso.model.entity.Post;
import com.vso.model.entity.User;
import com.vso.model.service.authentication.AuthenticationServiceImpl;
import com.vso.view.BaseScreen;
import com.vso.view.InitComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class PostSection extends BaseScreen {

    private static final PostController postController = new PostController();
    private static final UserController userController = new UserController();

    public PostSection() {
    }

    @Override
    protected LayoutManager getLayoutManager() {
        return new GridBagLayout();
    }

    @Override
    protected void setupComponents() {
    }

    public static void setupPostSection(int gridYInitial, JPanel controlPanel, User user) {
        User loggedUser = AuthenticationServiceImpl.getLoggedUser();

        try {
            int counter = 0;
            int gridXInitial = 0;

            for (Post post : posts()) {

                GridBagConstraints c = new GridBagConstraints();
                counter++;

                JLabel lbPhoto = InitComponent.imageLabel(userController.showUserAvatar(loggedUser), 60, 60, c, gridXInitial, gridYInitial, 10, 0);
                assert lbPhoto != null;
                lbPhoto.setPreferredSize(new Dimension(100, 100));
                lbPhoto.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.lightGray));
                controlPanel.add(lbPhoto, c);

                JLabel lbPostDescription = InitComponent.txtLabel(post.getText(), c, gridXInitial + 1, gridYInitial, 0, 0);
                lbPostDescription.setPreferredSize(new Dimension(300, 100));
                lbPostDescription.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.lightGray));
                controlPanel.add(lbPostDescription, c);

                JButton btnReport = InitComponent.button("Report", c, gridXInitial + 2, gridYInitial, 100, 100);
                btnReport.setPreferredSize(new Dimension(60, 40));
                controlPanel.add(btnReport, c);

                if (counter == 1) {
                    counter = 0;
                    gridYInitial++;
                    gridXInitial = 0;
                } else {
                    gridXInitial++;
                }

                long id = post.getId();

                lbPhoto.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
//                        LikePostSection likePostSection = new LikePostSection(post, navigation, user);
//                        likePostSection.setComponents(post);
                        System.out.println("Yay you clicked me + " + id);
                    }
                });
            }
        } catch (NullPointerException ignored) {

        }
    }

    public static List<Post> posts() {
        //TODO Chage the way user is passed
        User loggedUser = AuthenticationServiceImpl.getLoggedUser();
        return postController.getAllPostsForUser(loggedUser);
    }

//TODO FIX IT WHEN BACKEND IS READY..........................
//    public static String multilineText(Post post) {
//        int textSize = post.getDescription().length() - 1;
//        String originalText = post.getDescription();
//        String insertHtml = "<html>";
//        String insertBr = "-<br>";
//        int index = 46;
//        String newString = new String();
//        for (int i = 0; i <= textSize; i++) {
//            if (i == 0) {
//                newString += insertHtml;
//            }
//            newString += originalText.charAt(i);
//            if (i % index == 0 && i != 0) {
//                newString += insertBr;
//            }
//        }
//        return newString;
//    }
}
