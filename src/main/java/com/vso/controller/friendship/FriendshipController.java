package com.vso.controller.friendship;

import com.vso.model.entity.Friendship;
import com.vso.model.entity.User;
import com.vso.model.service.block.BlockUser;
import com.vso.model.service.block.BlockUserImpl;
import com.vso.model.service.friend.FriendService;
import com.vso.model.service.friend.FriendServiceImpl;
import com.vso.view.SystemMsgsView;

import java.util.List;

public class FriendshipController {

    private final BlockUser blockUser = new BlockUserImpl();
    private final FriendService friendService = new FriendServiceImpl();
    private final SystemMsgsView systemMsgsView = new SystemMsgsView();

    public FriendshipController() {
    }

    public boolean isUserBlocked(User loggedUser, User requested) {
        if (blockUser.allFriendships(loggedUser) == null) {
            return false;
        }

        for (Friendship friendship : blockUser.allFriendships(loggedUser)) {
            if (requested == friendship.getRequested() && friendship.getFriendship_status().equals("blocked")) {
                return true;
            }
        }
        return false;
    }

    public void blockUser(User loggedUser, User requested) {
        if (loggedUser == null) {
            systemMsgsView.showLoggedUserIsNull();
        } else if (requested == null) {
            systemMsgsView.showRequestedUserIsNull();
        } else {
            blockUser.setFriendshipBlocked(loggedUser, requested);
        }
    }

    public void unblockUser(User loggedUser, User requested) {
        blockUser.setFriendshipUnblocked(getFriendshipId(loggedUser, requested));
    }

    public long getFriendshipId(User loggedUser, User requested) {
        long friendshipId = -1;
        for (Friendship friendship : friendService.getAllFriends(loggedUser)) {
            if (requested == friendship.getRequested()) {
                friendshipId = friendship.getId();
            }
        }
        return friendshipId;
    }

    public void sendFriendRequest(User loggedUser, User requested) {
        if (loggedUser == null) {
            systemMsgsView.showLoggedUserIsNull();
        } else if (requested == null) {
            systemMsgsView.showRequestedUserIsNull();
        } else {
           friendService.sendFriendRequest(loggedUser,requested);
        }
    }

    public void acceptFriendRequest(User loggedUser, User requested) {
        if (loggedUser == null) {
            systemMsgsView.showLoggedUserIsNull();
        } else if (requested == null) {
            systemMsgsView.showRequestedUserIsNull();
        } else {
            friendService.setFriendshipStatusAccepted(getFriendshipId(loggedUser, requested));
        }
    }

    public void cancelFriendRequest(User loggedUser, User requested) {
        if (loggedUser == null) {
            systemMsgsView.showLoggedUserIsNull();
        } else if (requested == null) {
            systemMsgsView.showRequestedUserIsNull();
        } else {
            friendService.setFriendshipStatusNull(getFriendshipId(requested, loggedUser));
        }
    }

    public List<Friendship> getAllFriendRequests(User loggedUser) {
        if (friendService.getAllFriends(loggedUser) == null) {
            systemMsgsView.showRequestedUserIsNull();
        } else {
            for (Friendship friendship : friendService.getAllFriends(loggedUser)) {
                if (loggedUser == friendship.getRequested() && friendship.getFriendship_status().equals("pending")) {
                    return (List<Friendship>) friendship;
                }
            }
        }
        return null;
    }

    public boolean areUsersFriends(User loggedUser, User requested) {
        if (friendService.getAllFriends(loggedUser) == null) {
            return false;
        }

        for (Friendship friendship : friendService.getAllFriends(loggedUser)) {
            if (requested == friendship.getRequested() && friendship.getFriendship_status().equals("friends")) {
                return true;
            }
        }
        return false;
    }
}