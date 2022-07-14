package com.vso.frontEnd;

public class Navigation {

    private final AuthenticationScreen authenticationScreen;
    private final RegisterScreen registerScreen;

    private final ResetScreen resetScreen;
    private final ForgottenPassScreen forgottenPassScreen;

    public Navigation() {
        this.authenticationScreen = new AuthenticationScreen(this::redirectToRegister,this::redirectToForgottenPassword);
        this.registerScreen = new RegisterScreen(this);
        this.forgottenPassScreen = new ForgottenPassScreen(this,this::redirectToReset);
        this.resetScreen = new ResetScreen(this);
    }

    private void redirectToRegister() {
        authenticationScreen.hideScreen();
        registerScreen.makeVisible();
    }

    private void redirectToForgottenPassword(){
        authenticationScreen.hideScreen();
        forgottenPassScreen.makeVisible();
    }

    private void redirectToReset(){
        forgottenPassScreen.hideScreen();
        resetScreen.makeVisible();

    }

    public void startNavigation() {
        authenticationScreen.makeVisible();
    }

    public void navigateToDashboard() {

    }
}
