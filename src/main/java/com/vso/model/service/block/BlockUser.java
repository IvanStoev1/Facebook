package com.vso.model.service.block;

import com.vso.model.entity.Friendship;
import com.vso.model.entity.User;

import java.util.List;

public interface BlockUser {

    void setFriendshipBlocked(User loggedUser, User requested);

    void setFriendshipUnblocked(long friendshipId);

    List<Friendship> allFriendships(User loggedUser);
}
