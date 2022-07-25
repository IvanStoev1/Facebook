package com.vso.controller.avatarController;

import com.vso.model.entity.Photo;

import java.util.List;

public interface AvatarController {

    int getGallerySize();

    List<Photo> getGallery();

    void setNewAvatar(long newAvatarId, String newAvatarPhotoUrl);
}
