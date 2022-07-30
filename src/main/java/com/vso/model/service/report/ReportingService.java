package com.vso.model.service.report;

import com.vso.model.entity.Post;

public interface ReportingService {
    void report(Post post);

    void delete(Post post);
}
