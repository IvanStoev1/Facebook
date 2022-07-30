//package com.vso.controller.likeController;
//
//import com.vso.model.dao.LikePhotoDao;
//import com.vso.model.entity.Likephoto;
//import com.vso.model.entity.Photo;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class PhotoLikeController {
//
//    private final LikePhotoServiceImpl likePhotoService;
//    private static final LikePhotoDao likePhotoDao = new LikePhotoDao();
//
//    public PhotoLikeController() {
//        this.likePhotoService = new LikePhotoServiceImpl();
//    }
//
//    public void setNewLike(Photo photo) {
//        likePhotoService.likePhoto(photo);
//    }
//
//    public String countLikes(Photo photo){
//        return likePhotoService.countLikes(photo);
//    }
//
//    public List<Likephoto> showRecordSetOfLikes(Photo photo){
//        return likePhotoDao.getLikesForThisPicture(photo);
//    }
//
//    public List<Likephoto> likesForThisPic(Photo photo) {
//        return showRecordSetOfLikes(photo)
//                .stream()
//                .filter(l -> l.getPhoto().getId().equals(photo.getId()))
//                .collect(Collectors.toList());
//    }
//}
