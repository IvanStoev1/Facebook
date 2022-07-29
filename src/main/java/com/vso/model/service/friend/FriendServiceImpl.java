package com.vso.model.service.friend;

import com.vso.model.dao.FriendshipDao;
import com.vso.model.entity.Friendship;
import com.vso.model.entity.User;

import java.util.List;

public class FriendServiceImpl {

    FriendshipDao friendshipDao;

    public FriendServiceImpl() {
        friendshipDao = new FriendshipDao();
    }

    public void setFriendshipStatusPending(long friendshipID){
        friendshipDao.updateFriendshipStatus(friendshipID,"pending");
    }

    public void setFriendshipStatusAccepted(long friendshipId) {
        friendshipDao.updateFriendshipStatus(friendshipId, "accepted");
    }

    public void setFriendshipStatusNull(long friendshipId) {
        friendshipDao.updateFriendshipStatus(friendshipId, null);
    }

    public List<Friendship> getAllFriends(User loggedUser) {
        return friendshipDao.getAllFriends(loggedUser);
    }

}
