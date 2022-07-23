package com.vso.controller.photoController;

import com.vso.model.entity.Photo;
import com.vso.model.entity.User;

import java.util.List;

public interface PhotoController {

    List<Photo> showUserPhotos(User loggedUser);
}
