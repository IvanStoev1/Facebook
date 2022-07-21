package com.vso.model.service.uploadPost;

import com.vso.model.dao.UserDao;
import com.vso.model.entity.Post;
import com.vso.model.entity.User;
import com.vso.model.enumaration.PostPrivacyStatus;
import com.vso.view.uploadingPostView.UploadPostView;

import java.time.LocalDate;

public class UploadingService {
    private User author;
    private UploadPostView uploadPostView;
    private Post post;
    private UserDao userDao;

    public UploadingService(User user, UserDao userDao) {
        this.author = user;
        this.uploadPostView = new UploadPostView();
        this.post = new Post();
        this.userDao = userDao;
    }

    public void startUploadingProcess() {
        createPost();
        addPostToPostList(post);
        userDao.addPost(post);
        uploadPostView.printPost(post);
    }

    private void createPost() {
        uploadPostView.getText("Create your Post \n" +
                "Add description:");
        String description = uploadPostView.getTextInput();
        post.setText(description);
        LocalDate todaysDate = LocalDate.now();
        post.setDate(todaysDate);
        post.setPrivacy_status(choosePrivacyStatus());
        post.setUser(author);
    }

    private PostPrivacyStatus choosePrivacyStatus() {
        uploadPostView.getText("Select status: \n" +
                "1.Everyone\n" +
                "2.Only friends");
        int userOption = uploadPostView.getNumber();
        if(userOption > 2 || userOption < 0){
            uploadPostView.getText("Invalid input");
            choosePrivacyStatus();
        }
        switch (userOption) {
            case 1 : return PostPrivacyStatus.EVERYONE;
            case 2 : return PostPrivacyStatus.ONLY_FRIENDS;
            default : return null;
        }
    }

    private void addPostToPostList(Post post) {
        post.getUser().getPosts().add(post);
    }
}
