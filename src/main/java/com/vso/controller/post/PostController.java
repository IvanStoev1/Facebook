package com.vso.controller.post;

import com.vso.model.dao.PostDao;
import com.vso.model.entity.Post;
import com.vso.model.entity.User;

import java.util.List;

public class PostController {

    private PostDao postDao;

    public PostController() {
        this.postDao = new PostDao();

    }

    public List<Post> getAllPostsForUser(User thisUser){
        return PostDao.selectPostsByUserId(thisUser);
    }
}
