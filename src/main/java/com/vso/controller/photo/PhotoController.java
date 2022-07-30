package com.vso.controller.photo;

import com.vso.model.dao.PhotoDao;
import com.vso.model.entity.Photo;
import com.vso.model.entity.User;
import com.vso.model.service.upload.UploadPhotoImpl;
import com.vso.view.SystemMsgsView;

import java.util.List;

public class PhotoController {

    private final PhotoDao photoDao;
    private final UploadPhotoImpl uploadPhoto;
    private final SystemMsgsView systemMsgsView;

    public PhotoController() {
        this.photoDao = new PhotoDao();
        this.uploadPhoto = new UploadPhotoImpl();
        this.systemMsgsView = new SystemMsgsView();
    }

    public List<Photo> showUserPhotos(User loggedUser){
        return photoDao.selectPhotosByUserId(loggedUser);
    }

    public void uploadPhoto(String description, String imageSource) {
        if (imageSource.isEmpty()) systemMsgsView.showEmptyFileChooser();
        else {
            uploadPhoto.uploadPicture(description, imageSource);
            systemMsgsView.showSuccessfulUpload();
        }
    }
}
