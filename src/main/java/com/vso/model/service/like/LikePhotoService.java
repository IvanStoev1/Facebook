package com.vso.model.service.like;

import com.vso.model.entity.Photo;

public interface LikePhotoService {

    public void likePhoto(Photo photo);

    public String countLikes(Photo photo);
}
