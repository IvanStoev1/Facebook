package com.vso.frontEnd;

import java.awt.*;

public class ForgottenPassScreen extends BaseScreen{

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
