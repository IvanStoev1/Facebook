package com.vso.model.service.uploadPhotoService;

import com.vso.model.dao.PhotoDao;
import com.vso.model.entity.Photo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class UploadPhotoService {

    private final PhotoDao photoDao;

    public UploadPhotoService() {
        this.photoDao = new PhotoDao();
    }

    public void UploadPictures(String description, String imageSource) throws IOException {
        UploadPhotoInDirectory(imageSource);
        UploadPhotoInDatabase(description);
    }

    private void UploadPhotoInDirectory(String imageSource)throws IOException{
        Path pasteTo = Path.of(UploadDestination());
        Path copyFrom = Path.of(imageSource);
        Files.copy(copyFrom.normalize(), pasteTo.normalize());
    }

    private void UploadPhotoInDatabase(String description) {
        Photo newPhoto = new Photo();
        newPhoto.setUser_id(1L);
        newPhoto.setDescription(description);
        newPhoto.setUrl(UploadDestination());
        photoDao.insertNewPhotoInDb(newPhoto);
    }

    private String UploadDestination() {
        String appPath = ((new File(".").
                getAbsoluteFile()).
                toString()).
                replace(".","");
        String uploadDestination = appPath + "src\\main\\resources\\Upload";
        long fileName = photoDao.getLast() + 1;

        return uploadDestination + "\\" + fileName + ".png";
    }
}
