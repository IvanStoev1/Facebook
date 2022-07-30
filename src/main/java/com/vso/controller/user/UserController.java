package com.vso.controller.user;

import com.vso.model.dao.PhotoDao;
import com.vso.model.dao.UserDao;
import com.vso.model.entity.User;
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

    public String showUserAvatar(User user){
        return userDao.accessUserAvatar(user);
    }

    public String userInfo(User user){
        return userDao.accessUserInfo(user);
    }
}
