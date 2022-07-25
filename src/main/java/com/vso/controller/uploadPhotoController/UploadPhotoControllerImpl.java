package com.vso.controller.uploadPhotoController;

import com.vso.model.entity.Photo;
import com.vso.model.service.uploadPhotoService.UploadPhotoService;

import java.util.List;

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
