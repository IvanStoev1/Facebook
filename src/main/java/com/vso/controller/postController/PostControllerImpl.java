package com.vso.controller.postController;

import com.vso.model.dao.PostDao;
import com.vso.model.entity.Post;
import com.vso.model.entity.User;

import java.util.List;

public class PostControllerImpl implements PostController {

    private PostDao postDao;

    public PostControllerImpl() {
        this.postDao = new PostDao();
    }

    @Override
    public List<Post> getAllPostsForUser(User thisUser){
        return postDao.selectPostsByUserId(thisUser);
    }
}
