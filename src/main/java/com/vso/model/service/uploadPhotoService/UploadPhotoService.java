package com.vso.model.service.uploadPhotoService;

import com.vso.model.dao.PhotoDao;
import com.vso.model.entity.Photo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class UploadPhotoService {
    private String imageSource;
    private final PhotoDao photoDao;

    public UploadPhotoService() throws IOException {
        this.photoDao = new PhotoDao();
    }

    public void UploadPictures(String description, String imageSource, int loggedUser) throws IOException {
        UploadPhotoInDirectory(this.imageSource);
        UploadPhotoInDatabase(loggedUser, description, imageSource);
    }

    private String UploadPhotoInDirectory(String imageSource)throws IOException{
        String appPath = ((new File(".").
                getAbsoluteFile()).
                toString()).
                replace(".","");
        String uploadDestination = appPath + "src\\main\\resources\\Upload";
        long fileName = photoDao.getLastId() + 1;

        File pasteTo = new File(uploadDestination + "\\" + fileName + ".png");
        File copyFrom = new File(imageSource);
        Files.copy(copyFrom.toPath(), pasteTo.toPath());
        return pasteTo.toString();
    }

    private void UploadPhotoInDatabase(int loggedUser, String description, String imageSource) throws IOException {
        Photo newPhoto = new Photo();
        newPhoto.setUser_id(loggedUser);
        newPhoto.setDescription(description);
        newPhoto.setUrl(UploadPhotoInDirectory(imageSource));
        photoDao.insertNewPhotoInDb(newPhoto);
    }
}
