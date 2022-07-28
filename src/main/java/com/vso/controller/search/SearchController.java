package com.vso.controller.search;

import com.vso.model.entity.User;
import com.vso.model.service.search.SearchBar;

import java.util.List;

public class SearchController {

    private final SearchBar searchBar = new SearchBar();

    public SearchController() {
    }

    public static List<User> findUser(String searchedUser){
        return  SearchBar.findUser(searchedUser);
    }
}
