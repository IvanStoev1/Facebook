package com.vso.view.requests;

import com.vso.view.BaseScreen;
import com.vso.view.InitComponent;
import com.vso.view.Navigation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Requests extends BaseScreen {

    private final Navigation navigation;

    public Requests(Navigation navigation) {
        this.navigation = navigation;
        setComponents();
    }

    @Override
    protected GridBagLayout getLayoutManager() {
        return new GridBagLayout();
    }

    @Override
    protected void setupComponents() {

    }

    public void setComponents() {
        getContentPanel().setLayout(getLayoutManager());
        GridBagConstraints c = new GridBagConstraints();

        int gridXInitial = 0;
        int gridYInitial = 0;
        JLabel lbUserName = InitComponent.txtLabel("FRIEND REQUEST", c, gridXInitial, gridYInitial, 0, 0);
        lbUserName.setPreferredSize(new Dimension(300, 80));
        lbUserName.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.blue));
        getContentPanel().add(lbUserName, c);
        addHomeBtn(c, gridXInitial, gridYInitial);

    }

    private void addHomeBtn(GridBagConstraints c, int gridXInitial, int gridYInitial) {
        JButton homeBtn = InitComponent.button("HOME", c, gridXInitial, gridYInitial, 900, 300);
        getContentPanel().add(homeBtn, c);

        homeBtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigation.redirectRequestsToHome();
            }
        });
    }
}
