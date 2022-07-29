//package com.vso.view.profile;
//
//import com.vso.model.entity.Post;
//import com.vso.model.entity.User;
//import com.vso.model.service.authentication.AuthenticationServiceImpl;
//import com.vso.view.BaseScreen;
//import com.vso.view.InitComponent;
//import com.vso.view.Navigation;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class LikePostSection extends BaseScreen {
//
//    private Navigation navigation;
//    private LikePostRecordSet likePostRecordSet = new LikePostRecordSet();
//    private User user;
//    private Post post;
//
//    public LikePostSection(Navigation navigation) {
//        this.navigation = navigation;
//        setSize(600, 400);
//        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        setTitle("Like Post");
//    }
//
//    public LikePostSection(Post post, Navigation navigation, User user) {
//        this.navigation = navigation;
//        this.post = post;
//        this.user = user;
//        setSize(600, 400);
//        makeVisible();
//        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        setTitle("Like Post");
//    }
//
//    @Override
//    protected GridBagLayout getLayoutManager() {
//        return new GridBagLayout();
//    }
//
//    protected void setComponents(Post post) {
//        getContentPanel().setLayout(getLayoutManager());
//        GridBagConstraints c = new GridBagConstraints();
//
//        //TODO in backend calculate likes for post: photoLikeController.countLikes(photo)
//        JButton btnLike = InitComponent.button(" Like", c, 0, 0, 10, 0);
//        getContentPanel().add(btnLike, c);
//
//        JButton btnAddComment = InitComponent.button("Select As Avatar", c, 1, 0, 0, 10);
//        getContentPanel().add(btnAddComment, c);
//
//        JTextField txtComment = InitComponent.txtField(c, 1, 0, 0, 10);
//        getContentPanel().add(txtComment, c);
////TODO class LikePostRecordSet is commented, remove this comment when fix LikePostRecordSet
////        LikePostRecordSet.setComponents(1, getContentPanel(), post);
//
//        btnAddComment.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                //TODO Create new comment...........................................
//            }
//        });
//
//        btnLike.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Window[] win = Window.getWindows();
//                if (user == AuthenticationServiceImpl.getLoggedUser()) {
//
//                    for (Window window : win) window.dispose();
//                    navigation.redirectFromPostSectionToMyProfile();
////                    MyProfileView profileView = new MyProfileView(navigation);
////                    profileView.makeVisible();
////                    profileView.setComponents();
//                } else {
//
//                    for (Window window : win) window.dispose();
//
//                    UserProfileView profile = new UserProfileView(user);
//                    profile.makeVisible();
//                    profile.setComponents();
//                }
//            }
//        });
//    }
//
//    @Override
//    protected void setupComponents() {
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public void setNavigation(Navigation navigation) {
//        this.navigation = navigation;
//    }
//
//}