package com.vso.model.service.like;

import com.vso.model.entity.Like;
import com.vso.model.entity.Post;
import com.vso.model.service.authentication.AuthenticationServiceImpl;

public class LikeService {
    public void likePost(Post post) {
        new Like(AuthenticationServiceImpl.getLoggedUser(), post);
    }
}
