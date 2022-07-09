package com.vso.model.service;

import com.vso.model.entity.Post;
import com.vso.model.entity.User;

import java.util.HashSet;
import java.util.Set;

public class DeleteService {

    public void likePost(User user, Post post) {
        Set<User> likes;
        if(post.getLikes() != null)
            likes = post.getLikes();
        else {
            likes = new HashSet<>();
        }
        likes.add(user);
        post.setLikes(likes);
    }


}
