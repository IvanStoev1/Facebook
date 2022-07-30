package com.vso.model.service.upload;

import com.vso.model.dao.PhotoDao;
import com.vso.model.entity.Photo;
import com.vso.model.service.authentication.AuthenticationServiceImpl;
import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class UploadPhotoImpl implements UploadPhoto {

    private final PhotoDao photoDao;

    public UploadPhotoImpl() {
        this.photoDao = new PhotoDao();
    }

    @Override
    public void uploadPicture(String description, String imageSource) {
        uploadPhotoInDirectory(imageSource);
        uploadPhotoInDatabase(description, imageSource);
    }

    private void uploadPhotoInDirectory(String imageSource) {
        Path pasteTo = Path.of(uploadDestination(imageSource));
        Path copyFrom = Path.of(imageSource);

        try {
            Files.copy(copyFrom.normalize(), pasteTo.normalize());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void uploadPhotoInDatabase(String description, String imageSource) {
        Photo newPhoto = new Photo();
        newPhoto.setUser(AuthenticationServiceImpl.getLoggedUser());
        newPhoto.setDescription(description);
        newPhoto.setUrl(uploadDestination(imageSource));
        photoDao.insertNewPhotoInDb(newPhoto);
    }

    private String uploadDestination(String imageSource) {
        String uploadDestination = "src\\main\\resources\\Upload";
        long fileName = photoDao.getLast() + 1;
        String extension = getExtensionByStringHandling(imageSource);
        return uploadDestination + "\\" + fileName + "." + extension;
    }

    private String getExtensionByStringHandling(String imageSource) {
        return FilenameUtils.getExtension(imageSource);
    }
}
