package com.vso.model.service.report;

import com.vso.model.entity.Post;
import com.vso.model.entity.User;


public class DeletePostImpl extends User implements DeletePost {


    public class Admin extends User {

    }

    @Override
    public void deletePost(Post post) {
        ReportingServiceImpl.delete(post);
    }
}