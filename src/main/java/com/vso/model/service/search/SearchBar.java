package com.vso.model.service.search;

import com.vso.model.dao.UserDao;
import com.vso.model.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class SearchBar {

    private UserDao userDao;

    public SearchBar() {
    }

    public static List<User> findUser(String userName) {
        return UserDao.getAllUsers().stream().
                filter(user -> user.getName().toUpperCase().
                        contains(userName.toUpperCase())).
                collect(Collectors.toList());
    }
}
