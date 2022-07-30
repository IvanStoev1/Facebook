package com.vso.view.deleted;

import com.vso.view.BaseScreen;
import com.vso.view.InitComponent;
import com.vso.view.Navigation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DeletedScreen extends BaseScreen {

    public DeletedScreen() {
    }

    @Override
    protected GridBagLayout getLayoutManager() {
        return new GridBagLayout();
    }

    public void setComponents(){

        getContentPanel().setLayout(getLayoutManager());
        GridBagConstraints c = new GridBagConstraints();

        JLabel lbInfo = InitComponent.txtLabel("You are out of our app, you will be always welcome back!", c, 0, 0, 10, 0);
        getContentPanel().add(lbInfo, c);

        JButton btnBack = InitComponent.button("Come back", c, 0, 1, 10, 0);
        getContentPanel().add(btnBack, c);

        JButton btnLeave = InitComponent.button("Leave", c, 0, 2, 10, 0);
        getContentPanel().add(btnLeave, c);

        btnBack.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                hideScreen();
                Navigation navigation = new Navigation();
                navigation.startNavigation();
            }
        });

        btnLeave.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }

    @Override
    protected void setupComponents() {

    }
}
