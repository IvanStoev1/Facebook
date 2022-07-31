package com.vso.view.requests;

import com.vso.view.BaseScreen;
import com.vso.view.InitComponent;
import com.vso.view.Navigation;

import javax.swing.*;
import java.awt.*;

public class Requests extends BaseScreen {

    private final Navigation navigation;

    public Requests(Navigation navigation) {
        this.navigation = navigation;
        setComponents();
    }

    @Override
    protected LayoutManager getLayoutManager() {
        return new GridBagLayout();
    }

    @Override
    protected void setupComponents() {

    }

    public void setComponents(){
        getContentPanel().setLayout(getLayoutManager());
        GridBagConstraints c = new GridBagConstraints();

        int gridXInitial = 0;
        int gridYInitial = 0;
        JLabel lbUserName = InitComponent.txtLabel("FRIEND REQUEST", c, gridXInitial, gridYInitial, 0, 0);
        lbUserName.setPreferredSize(new Dimension(300, 80));
        lbUserName.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.blue));
        getContentPanel().add(lbUserName, c);

    }
}
