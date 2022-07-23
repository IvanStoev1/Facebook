package com.vso.controller.postController;

import com.vso.model.entity.Post;
import com.vso.model.entity.User;

import java.util.List;

public interface PostController {

    List<Post> getAllPostsForUser(User thisUser);
}
