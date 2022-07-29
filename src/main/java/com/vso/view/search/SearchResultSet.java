package com.vso.view.search;

import com.vso.controller.search.SearchController;
import com.vso.model.entity.User;
import com.vso.model.service.authentication.AuthenticationServiceImpl;
import com.vso.view.BaseScreen;
import com.vso.view.InitComponent;
import com.vso.view.Navigation;
import com.vso.view.profile.MyProfileView;
import com.vso.view.profile.UserProfileView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SearchResultSet extends BaseScreen {

    private static Navigation navigation;
    private static SearchController searchController;
    private Search search;

    public SearchResultSet(Navigation navigation){
        SearchResultSet.navigation = navigation;
    }

    @Override
    protected GridBagLayout getLayoutManager() {
        return new GridBagLayout();
    }
    //TODO STATIC
    public static void setComponents(int gridYInitial, JPanel controlPanel, String userName){
        try {
            int counter = 0;
            int gridXInitial = 0;

            for (User user : SearchController.findUser(userName)) {
                System.out.println("THIS IS WHAT I FOUND: " + user);
                GridBagConstraints c = new GridBagConstraints();
                counter++;

                JLabel lbPhoto = InitComponent.imageLabel(user.getAvatarUrl(), 60, 60, c, gridXInitial, gridYInitial, 10, 0);
                assert lbPhoto != null;
                lbPhoto.setPreferredSize(new Dimension(300, 80));
                lbPhoto.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.blue));
                controlPanel.add(lbPhoto, c);

                JLabel lbPostId = InitComponent.txtLabel(user.getName(), c, gridXInitial+1, gridYInitial, 0, 0);
                lbPostId.setPreferredSize(new Dimension(300, 80));
                lbPostId.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.blue));
                controlPanel.add(lbPostId, c);

                JToggleButton tgbtnFriendshipStatus = InitComponent.tgBtnFriendship("Add Friend", c, gridXInitial+2, gridYInitial, 20, 5);
                tgbtnFriendshipStatus.setPreferredSize(new Dimension(100, 50));
                controlPanel.add(tgbtnFriendshipStatus, c);

                JToggleButton tgbtnBlockUser = InitComponent.tgBtnFriendship("Block User", c, gridXInitial+3, gridYInitial, 0, 20);
                tgbtnBlockUser.setPreferredSize(new Dimension(100, 50));
                controlPanel.add(tgbtnBlockUser, c);

                if (counter == 1) {
                    counter = 0;
                    gridYInitial++;
                    gridXInitial = 0;
                } else {
                    gridXInitial++;
                }

                lbPhoto.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (user.getId() == AuthenticationServiceImpl.getLoggedUser().getId()){

                            MyProfileView myProfileView = new MyProfileView(navigation);
                            myProfileView.setComponents();
                            myProfileView.makeVisible();
                            System.out.println("MY PROFILE " + AuthenticationServiceImpl.getLoggedUser());

                        } else if (user.getId() != AuthenticationServiceImpl.getLoggedUser().getId()){

                            System.out.println("SOMEONE ELSE " + user);
                            UserProfileView profile = new UserProfileView(user);
                            profile.makeVisible();

                        }
                    }
                });
            }
        } catch (NullPointerException ignored) {

        }
    }

    @Override
    protected void setupComponents() {

    }
}