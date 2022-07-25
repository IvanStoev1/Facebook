package com.vso.controller.avatarController;

import com.vso.model.dao.PhotoDao;
import com.vso.model.entity.Photo;
import com.vso.model.service.avatarUpdateService.UpdateAvatarService;
import com.vso.model.service.avatarUpdateService.UpdateAvatarServiceImpl;

import java.util.List;

public class AvatarControllerImpl implements AvatarController {

    private final PhotoDao photoDao;
    private final UpdateAvatarService updateAvatarService;

    public AvatarControllerImpl() {
        this.photoDao = new PhotoDao();
        this.updateAvatarService = new UpdateAvatarServiceImpl();
    }

    @Override
    public int getGallerySize() {
        return photoDao.getGallerySize();
    }

    @Override
    public List<Photo> getGallery() {
        return photoDao.selectPhotosByUserId();
    }
    @Override
    public void setNewAvatar(long newAvatarId, String newAvatarPhotoUrl) {
        updateAvatarService.updateAvatarPhoto(newAvatarId, newAvatarPhotoUrl);
    }
}
