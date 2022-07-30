package com.vso.model.service.friend;

import com.vso.model.entity.Friendship;
import com.vso.model.entity.User;

import java.util.List;

public interface FriendService {

    void sendFriendRequest(User loggedUser,User requested);

    void setFriendshipStatusAccepted(long friendshipId);

    void setFriendshipStatusNull(long friendshipId);

    List<Friendship> getAllFriends(User loggedUser);

}
