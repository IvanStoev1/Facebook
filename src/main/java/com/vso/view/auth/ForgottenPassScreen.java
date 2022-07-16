package com.vso.view.auth;

import com.vso.view.BaseScreen;
import com.vso.view.Navigation;

import java.awt.*;

public class ForgottenPassScreen extends BaseScreen {

    Navigation navigation;

    public ForgottenPassScreen(Navigation navigation){
        this.navigation = navigation;
    }


    @Override
    protected LayoutManager getLayoutManager() {
        return new GridBagLayout();
    }

    @Override
    protected void setupComponents() {

    }
}
