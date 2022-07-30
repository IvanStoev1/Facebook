package com.vso.model.service.friend;

import com.vso.model.dao.FriendshipDao;
import com.vso.model.entity.Friendship;
import com.vso.model.entity.User;

import java.util.List;

public class FriendServiceImpl implements FriendService {

    FriendshipDao friendshipDao;

    public FriendServiceImpl() {
        friendshipDao = new FriendshipDao();
    }

    @Override
    public void sendFriendRequest(User loggedUser, User requested) {
        Friendship friendship = new Friendship();
        friendship.setRequester(loggedUser);
        friendship.setRequested(requested);
        friendship.setFriendship_status("pending");
        friendshipDao.insertUser(friendship);
    }

    @Override
    public void setFriendshipStatusAccepted(long friendshipId) {
        friendshipDao.updateFriendshipStatus(friendshipId, "friends");
    }

    @Override
    public void setFriendshipStatusNull(long friendshipId) {
        friendshipDao.updateFriendshipStatus(friendshipId, null);
    }

    @Override
    public List<Friendship> getAllFriends(User loggedUser) {
        return FriendshipDao.getAllFriends(loggedUser);
    }

}
