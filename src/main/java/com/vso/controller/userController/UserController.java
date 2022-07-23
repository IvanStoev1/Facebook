package com.vso.controller.userController;

import com.vso.model.entity.Photo;
import com.vso.model.entity.User;

import java.util.List;

public interface UserController {

    int getGallerySize();

    List<Photo> getGallery(User loggedUser);

    void setNewAvatar(long newAvatarId, String newAvatarPhotoUrl);

    public String showUserAvatar(User user);

    public String userInfo(User user);

    public User getLoggedUser();
}
