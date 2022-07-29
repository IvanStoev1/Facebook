package com.vso.model.service.like;

import com.vso.model.dao.LikePhotoDao;
import com.vso.model.entity.Likephoto;
import com.vso.model.entity.Photo;
import com.vso.model.service.authentication.AuthenticationServiceImpl;

public class LikePhotoServiceImpl implements LikePhotoService {

    private final LikePhotoDao likePhotoDao;

    public LikePhotoServiceImpl() {
        this.likePhotoDao = new LikePhotoDao();
    }

    @Override
    public void likePhoto(Photo photo) {
        Likephoto like = new Likephoto();
        like.setUser(AuthenticationServiceImpl.getLoggedUser());
        like.setPhoto(photo);
        likePhotoDao.insertNewPhotoLike(like);
    }

    @Override
    public String countLikes(Photo photo){
        if (likePhotoDao.getLikesForThisPicture(photo) == null){
            return "";
        }
        return String.valueOf(likePhotoDao.countLikes(photo));
    }
}
