package com.vso.view.search;

import com.vso.controller.search.SearchController;
import com.vso.view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Search extends BaseScreen {

    private final Navigation navigation;
    private final SearchController searchController = new SearchController();
    private final SystemMsgsView systemMsgsView = new SystemMsgsView();
    private final SearchResultSet searchResultSet;

    public Search(Navigation navigation) {
        this.navigation = navigation;
        this.searchResultSet = new SearchResultSet(this);
        setTitle("Search friends");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setComponent();
    }

    @Override
    protected GridBagLayout getLayoutManager() {
        return new GridBagLayout();
    }

    @Override
    protected void setupComponents() {

    }

    public void setComponent() {

        getContentPanel().setLayout(getLayoutManager());
        GridBagConstraints c = new GridBagConstraints();

        JButton btnHome = InitComponent.button("HOME", c, 3, 0, 0, 20);
        getContentPanel().add(btnHome, c);

        JTextField txtUserName = InitComponent.txtField(c, 0, 0, 5, 5);
        txtUserName.setPreferredSize(new Dimension(300, 28));
        getContentPanel().add(txtUserName, c);

        JButton btnSearch = InitComponent.button("Search", c, 1, 0, 5, 5);
        getContentPanel().add(btnSearch, c);

        JButton btnNewSearch = InitComponent.button("New Search", c, 1, 0, 5, 5);
        getContentPanel().add(btnNewSearch, c);

        btnHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                navigation.redirectFromSearchToHome();
            }
        });

        btnNewSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Search search = new Search(navigation);
                search.makeVisible();
            }
        });

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String userName = txtUserName.getText().toUpperCase();
                int gridYInitial = 1;

                if (txtUserName.getText().isEmpty()) {
                    systemMsgsView.showEmptyNameTextField();
                } else {
                    if (SearchController.findUser(userName) != null) {
                        //TODO STATIC
                        searchResultSet.setComponents(gridYInitial, getContentPanel(), userName);
                        makeVisible();
                        btnSearch.setVisible(false);
                        btnNewSearch.setVisible(true);
                    }
                }
            }
        });
    }
}