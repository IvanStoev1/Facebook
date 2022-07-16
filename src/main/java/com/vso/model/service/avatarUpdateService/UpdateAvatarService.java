package com.vso.model.service.avatarUpdateService;

public interface UpdateAvatarService {

   void updateAvatarOrCoverPhoto(int loggedUser, long selectedPhotoId, String avatarOrCover);
}
