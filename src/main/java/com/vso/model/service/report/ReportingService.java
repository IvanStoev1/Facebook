package com.vso.model.service.report;

import com.vso.model.entity.Post;

import java.util.Date;

public class ReportingService {

    public void report(Post post) {
        new Report(post);
    }

    public static void delete(Post post) {
        post.setDeleted(new Date());
        post.getUser().getPosts().remove(post);
    }

    private static class Report {
        public Report(Post post) {
            post.setReported(new Date());
        }
    }
}