package com.vso.model.service.report;

import com.vso.model.entity.Post;
import com.vso.model.entity.User;

public class Amin extends User {
    public void deletePost(Post post) {
        ReportingService.delete(post);
    }
}