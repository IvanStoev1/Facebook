package com.vso.controller.uploadPhotoController;

import com.vso.model.entity.Photo;
import com.vso.model.service.uploadPhotoService.UploadPhotoService;
import com.vso.view.SystemMsgsView;
import com.vso.view.uploadPhotoView.UploadView;

import java.util.List;

public class UploadPhotoControllerImpl implements UploadPhotoController {

    private final UploadPhotoService uploadPhotoService;
    private final SystemMsgsView systemMsgsView;

    public UploadPhotoControllerImpl() {
        this.uploadPhotoService = new UploadPhotoService();
        this.systemMsgsView = new SystemMsgsView();
    }

    @Override
    public void uploadPhoto(String description, String imageSource) {
        if (imageSource.isBlank()){
            systemMsgsView.showEmptyFileChooser();
        } else {
            uploadPhotoService.UploadPictures(description, imageSource);
        }
    }
}
