package com.vso.view.profile;

import com.vso.controller.postController.PostController;
import com.vso.controller.postController.PostControllerImpl;
import com.vso.controller.user.UserController;
import com.vso.model.entity.Post;
import com.vso.model.entity.User;
import com.vso.model.service.authentication.AuthenticationServiceImpl;
import com.vso.view.BaseScreen;
import com.vso.view.InitComponent;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PostSection extends BaseScreen {

    private static final PostController postController = new PostControllerImpl();
    private static final UserController userController = new UserController();

    public PostSection() {

    }

    @Override
    protected GridBagLayout getLayoutManager() {
        return new GridBagLayout();
    }

    @Override
    protected void setupComponents() {
    }

    public static void setupPostSection(int gridYInitial, JPanel controlPanel){
        User loggedUser = AuthenticationServiceImpl.getLoggedUser();
        try {
            int counter = 0;
            int gridXInitial = 0;

            for (Post post : posts()) {
                JPanel postPanel = new JPanel();

                GridBagConstraints c;
                c = new GridBagConstraints();
                counter++;

                JLabel lbPostId = InitComponent.txtLabel(Long.toString(post.getId()), c, gridXInitial, gridYInitial, 0, 0);
                lbPostId.setPreferredSize(new Dimension(300, 80));
                lbPostId.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
                controlPanel.add(lbPostId, c);

                JLabel lbPhoto = InitComponent.imageLabel(userController.showUserAvatar(loggedUser),60, 60, c, gridXInitial+1, gridYInitial, 0, 0);
                assert lbPhoto != null;
                lbPhoto.setPreferredSize(new Dimension(300, 80));
                lbPhoto.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.red));
                controlPanel.add(lbPhoto, c);

                JLabel lbPostDescription = InitComponent.txtLabel(post.getText(), c, gridXInitial+2, gridYInitial, 0, 0);
                lbPostDescription.setPreferredSize(new Dimension(300, 80));
                lbPostDescription.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
                controlPanel.add(lbPostDescription, c);

                counter = 0;
                gridYInitial++;
                gridXInitial = 0;

                Post selectedPost = post;

//                lbPostDescription.addMouseListener(new MouseAdapter() {
//                    @Override
//                    public void mouseClicked(MouseEvent e) {
//                        LikeAndCommentSection likeAndCommentSection = new LikeAndCommentSection(post);
//                        likeAndCommentSection.makeVisible();
//                        System.out.println("Yay you clicked me + " + id);
//                    }
//                });
            }
        } catch (NullPointerException ignored) {

        }
    }

    public static int getLastYgrid(){
        if(posts() != null) {
            int printedComponents = posts().size();
            if (printedComponents % 3 == 0) {
                return printedComponents / 3;
            }
            return (printedComponents / 3) + 1;
        } return 4;
    }

    public static List<Post> posts() {
        //TODO Chage the way user is passed
        User loggedUser = AuthenticationServiceImpl.getLoggedUser();
        return postController.getAllPostsForUser(loggedUser);
    }
}
