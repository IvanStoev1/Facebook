package com.vso.controller.search;

import com.vso.model.dao.UserDao;
import com.vso.model.entity.User;

import java.util.List;

public class SearchController {

    public SearchController() {
    }

    public static List<User> findUser(String searchedUser){
        return  UserDao.findUser(searchedUser);
    }
}
