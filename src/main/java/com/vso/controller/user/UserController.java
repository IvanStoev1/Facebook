package com.vso.controller.user;

import com.vso.model.dao.PhotoDao;
import com.vso.model.dao.UserDao;
import com.vso.model.entity.User;
import com.vso.model.service.authentication.AuthenticationServiceImpl;
import com.vso.model.service.avatar.UpdateAvatarService;
import com.vso.model.service.avatar.UpdateAvatarServiceImpl;

public class UserController {

    private final PhotoDao photoDao;
    private final UserDao userDao;
    private final UpdateAvatarService updateAvatarService;

    public UserController() {
        this.photoDao = new PhotoDao();
        this.updateAvatarService = new UpdateAvatarServiceImpl();
        this.userDao = new UserDao();
    }

    public void setNewAvatar(String newAvatarPhotoUrl) {
        updateAvatarService.updateAvatarPhoto(newAvatarPhotoUrl);
    }

    public String showUserAvatar(){
        return userDao.accessUserAvatar();
    }

    public String userInfo(){
        return userDao.accessUserInfo();
    }

    public User getLoggedUser(){
        return AuthenticationServiceImpl.getLoggedUser();
    }
}
