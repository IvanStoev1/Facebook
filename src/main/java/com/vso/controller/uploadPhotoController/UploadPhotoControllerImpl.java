package com.vso.controller.uploadPhotoController;

import com.vso.model.service.upload.UploadPhotoService;

public class UploadPhotoControllerImpl implements UploadPhotoController {

    private final UploadPhotoService uploadPhotoService;

    public UploadPhotoControllerImpl() {
        this.uploadPhotoService = new UploadPhotoService();
    }

    @Override
    public void uploadPhoto(String description, String imageSource) {
        uploadPhotoService.UploadPictures(description, imageSource);
    }

}
