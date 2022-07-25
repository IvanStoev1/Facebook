package com.vso.model.service.upload;

import com.vso.model.dao.PhotoDao;
import com.vso.model.entity.Photo;
import com.vso.model.service.authentication.AuthenticationServiceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class UploadPhotoService {

    private final PhotoDao photoDao;

    public UploadPhotoService() {
        this.photoDao = new PhotoDao();
    }

    public void UploadPictures(String description, String imageSource) {
        UploadPhotoInDirectory(imageSource);
        UploadPhotoInDatabase(description);
    }

    private void UploadPhotoInDirectory(String imageSource) {

        Path pasteTo = Path.of(UploadDestination());
        Path copyFrom = Path.of(imageSource);

        try {
            Files.copy(copyFrom.normalize(), pasteTo.normalize());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void UploadPhotoInDatabase(String description) {
        Photo newPhoto = new Photo();
        newPhoto.setUser(AuthenticationServiceImpl.getLoggedUser());
        newPhoto.setDescription(description);
        newPhoto.setUrl(UploadDestination());
        photoDao.insertNewPhotoInDb(newPhoto);
    }

    private String UploadDestination() {
        String uploadDestination = "src\\main\\resources\\Upload";
        long fileName = photoDao.getLast() + 1;
        return uploadDestination + "\\" + fileName + ".png";
    }
}
