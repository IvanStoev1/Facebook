package com.vso.model.service.search;

import com.vso.model.data.UserDao;
import com.vso.model.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class SearchBar {
    private UserDao userDao;

    public SearchBar(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllMatches(String name) {
        return userDao.getAllUsers()
                .stream()
                .filter(user -> user.getName().equals(name) || first(user.getName()).equals(name)
                        || last(user.getName()).equals(name))
                .sorted()
                .collect(Collectors.toList());
    }

    private String first(String name) {
        return name.split(" ")[0];
    }

    private String last(String name) {
        return name.split(" ")[1];
    }
}
