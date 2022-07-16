package com.vso.controller;

import com.vso.model.service.authentication.AuthenticationService;
import com.vso.model.service.authentication.AuthenticationServiceImpl;
import com.vso.model.service.uploadPhotoService.UploadPhotoService;
import com.vso.view.Navigation;
import com.vso.view.uploadPhotoView.UploadView;

import java.io.IOException;

public class UploadPhotoController {

    private final UploadPhotoService uploadPhotoService;
    //private final AuthenticationService authenticationService;

    public UploadPhotoController() throws IOException {
        this.uploadPhotoService = new UploadPhotoService();
        //this.authenticationService = new AuthenticationServiceImpl();
    }

    public void uploadPhoto(String description, String imageSource) throws IOException {
        //int loggedUser = authenticationService.getLoggedUser().getId();
        uploadPhotoService.UploadPictures(description, imageSource);
    }
}
