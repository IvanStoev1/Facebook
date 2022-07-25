package com.vso.controller.userController;

import com.vso.model.dao.PhotoDao;
import com.vso.model.dao.UserDao;
import com.vso.model.entity.Photo;
import com.vso.model.entity.User;
import com.vso.model.service.authentication.AuthenticationServiceImpl;
import com.vso.model.service.avatarUpdateService.UpdateAvatarService;
import com.vso.model.service.avatarUpdateService.UpdateAvatarServiceImpl;

import java.util.List;

public class UserControllerImpl implements UserController {

    private final PhotoDao photoDao;
    private final UserDao userDao;
    private final UpdateAvatarService updateAvatarService;

    public UserControllerImpl() {
        this.photoDao = new PhotoDao();
        this.updateAvatarService = new UpdateAvatarServiceImpl();
        this.userDao = new UserDao();
    }

    @Override
    public int getGallerySize() {
        return photoDao.getGallerySize(getLoggedUser());
    }

    @Override
    public List<Photo> getGallery(User loggedUser) {
        return photoDao.selectPhotosByUserId(loggedUser);
    }
    @Override
    public void setNewAvatar(long newAvatarId, String newAvatarPhotoUrl) {
        updateAvatarService.updateAvatarPhoto(newAvatarId, newAvatarPhotoUrl);
    }
    @Override
    public String showUserAvatar(User user){
        return userDao.accessUserAvatar(user);
    }

    @Override
    public String userInfo(User user){
        return userDao.accessUserInfo(user);
    }

    @Override
    public User getLoggedUser(){
        return AuthenticationServiceImpl.getLoggedUser();
    }
}
