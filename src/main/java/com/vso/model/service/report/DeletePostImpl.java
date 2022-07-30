package com.vso.model.service.report;

import com.vso.model.entity.Post;
import com.vso.model.entity.User;

public class DeletePostImpl extends User implements DeletePost {

    private final ReportingService reportingService;

    public DeletePostImpl (ReportingService reportingService) {
        this.reportingService = reportingService;
    }

    @Override
    public void deletePost(Post post) {
        reportingService.delete(post);
    }
}