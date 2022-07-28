package com.vso.model.service.like;

import com.vso.model.dao.LikePhotoDao;
import com.vso.model.entity.Like;
import com.vso.model.entity.Likephoto;
import com.vso.model.entity.Photo;
import com.vso.model.entity.Post;
import com.vso.model.service.authentication.AuthenticationServiceImpl;

import java.util.List;

public class LikePhotoService {

    private final LikePhotoDao likePhotoDao;

    public LikePhotoService() {
        this.likePhotoDao = new LikePhotoDao();
    }

    public void likePhoto(Photo photo) {
        Likephoto like = new Likephoto();
        like.setUser(AuthenticationServiceImpl.getLoggedUser());
        like.setPhoto(photo);
        likePhotoDao.insertNewPhotoLike(like);
    }

    public String countLikes(Photo photo){
        if (likePhotoDao.getLikesForThisPicture(photo) == null){
            return "";
        }
        return String.valueOf(likePhotoDao.countLikes(photo));
    }
}
