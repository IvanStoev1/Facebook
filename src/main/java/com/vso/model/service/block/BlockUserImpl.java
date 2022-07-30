package com.vso.model.service.block;

import com.vso.model.dao.FriendshipDao;
import com.vso.model.entity.Friendship;
import com.vso.model.entity.User;

import java.util.List;

public class BlockUserImpl implements BlockUser {

    private final FriendshipDao friendshipDao;

    public BlockUserImpl() {
        this.friendshipDao = new FriendshipDao();
    }

    @Override
    public void setFriendshipBlocked(User loggedUser, User requested){
        Friendship blockedUser = new Friendship();
        blockedUser.setRequester(loggedUser);
        blockedUser.setRequested(requested);
        blockedUser.setFriendship_status("blocked");
        friendshipDao.insertUser(blockedUser);
    }

    @Override
    public void setFriendshipUnblocked(long friendshipId) {
            friendshipDao.updateFriendshipStatus(friendshipId, null);
    }

    @Override
    public List<Friendship> allFriendships(User loggedUser){
        return FriendshipDao.getAllFriends(loggedUser);
    }
}
