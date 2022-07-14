package com.vso.frontEnd;

public class Navigation {

    private final AuthenticationScreen authenticationScreen;
    private final RegisterScreen registerScreen;
    private final ForgottenPassScreen forgottenPassScreen;
    private final HomeScreen homeScreen;

    public Navigation() {
        this.authenticationScreen = new AuthenticationScreen(this::redirectToRegister,this::redirectToForgottenPass, this::redirectToHomeScreen);
        this.registerScreen = new RegisterScreen(this);
        this.forgottenPassScreen = new ForgottenPassScreen(this);
        this.homeScreen = new HomeScreen(this);

    }
    private void redirectToRegister(){
        authenticationScreen.hideScreen();
        registerScreen.makeVisible();
    }

    private void redirectToForgottenPass(){
        authenticationScreen.hideScreen();
        forgottenPassScreen.makeVisible();

    }

    private void redirectToHomeScreen(){
        authenticationScreen.hideScreen();
        homeScreen.makeVisible();
    }

    public void startNavigation () {
        authenticationScreen.makeVisible();
    }

    public void navigateToDashboard () {

    }
}