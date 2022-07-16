package com.vso.view;

import java.awt.*;

public class HomeScreen extends BaseScreen {
    Navigation navigation;

    public HomeScreen(Navigation navigation){
        this.navigation = navigation;
    }

    @Override
    protected LayoutManager getLayoutManager() {
        return null;
    }

    @Override
    protected void setupComponents() {

    }
}
