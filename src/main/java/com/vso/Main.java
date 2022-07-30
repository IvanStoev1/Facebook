package com.vso;

import com.vso.controller.friendship.FriendshipController;
import com.vso.model.dao.UserDao;
import com.vso.model.entity.User;
import com.vso.model.service.DeleteAccount;
import com.vso.model.service.authentication.AuthenticationService;
import com.vso.model.service.authentication.AuthenticationServiceImpl;
import com.vso.model.service.friend.FriendServiceImpl;
import com.vso.view.Navigation;
import org.hibernate.event.internal.DefaultLoadEventListener;

public class Main {

    public static void main(String[] args) {
        new Navigation().startNavigation();

    }
}
