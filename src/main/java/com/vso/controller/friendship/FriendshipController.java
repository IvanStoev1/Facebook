package com.vso.controller.friendship;

import com.vso.model.entity.Friendship;
import com.vso.model.entity.User;
import com.vso.model.service.block.BlockUserImpl;
import com.vso.view.SystemMsgsView;

public class FriendshipController {

    private final BlockUserImpl blockUser = new BlockUserImpl();
    private final SystemMsgsView systemMsgsView = new SystemMsgsView();

    public FriendshipController() {
    }

    public boolean isUserBlocked(User loggedUser, User requested){

        if (blockUser.allFriendships(loggedUser) == null){
            return false;
        }

        for (Friendship friendship : blockUser.allFriendships(loggedUser)) {
            if (requested == friendship.getRequested() && friendship.getFriendship_status().equals("blocked")){
                return true;
            }
        }
        return false;
    }

    public void  blockUser(User loggedUser, User requested){
        if (loggedUser == null){
            systemMsgsView.showLoggedUserIsNull();
        } else if (requested == null){
            systemMsgsView.showRequestedUserIsNull();
        } else {
            blockUser.setFriendshipBlocked(loggedUser, requested);
        }
    }

    public void unblockUser(User loggedUser, User requested){
        blockUser.setFriendshipUnblocked(getFriendshipId(loggedUser, requested));
    }

    public long getFriendshipId(User loggedUser, User requested){
        long friendshipId = -1;
        for (Friendship friendship : blockUser.allFriendships(loggedUser)) {
            if (requested == friendship.getRequested()){
                friendshipId = friendship.getId();
            }
        }
        return friendshipId;
    }


}
