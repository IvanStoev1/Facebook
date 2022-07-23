package com.vso.controller.photoController;

import com.vso.model.dao.PhotoDao;
import com.vso.model.entity.Photo;
import com.vso.model.entity.User;

import java.util.List;

public class PhotoControllerImpl implements PhotoController {

    private final PhotoDao photoDao;

    public PhotoControllerImpl() {
        this.photoDao = new PhotoDao();
    }

    @Override
    public List<Photo> showUserPhotos(User loggedUser){
        return photoDao.selectPhotosByUserId(loggedUser);
    }
}
