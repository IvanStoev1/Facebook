package com.vso.view;


import com.vso.view.auth.AuthenticationScreen;
import com.vso.view.forgottenPassword.DigitConfirmationScreen;
import com.vso.view.forgottenPassword.EmailFormScreen;
import com.vso.view.auth.RegisterScreen;
import com.vso.view.forgottenPassword.PasswordResetScreen;

public class Navigation {

    private final AuthenticationScreen authenticationScreen;
    private final RegisterScreen registerScreen;
    private final EmailFormScreen emailForm;
    private final HomeScreen homeScreen;
    private final PasswordResetScreen passwordReset;
    private final DigitConfirmationScreen digitConfirmationScreen;

    public Navigation() {
        this.authenticationScreen = new AuthenticationScreen(
                this::redirectToRegister,
                this::redirectToForgottenPass,
                this::redirectToHomeScreen
        );
        this.registerScreen = new RegisterScreen(this);
        this.emailForm = new EmailFormScreen(this);
        this.homeScreen = new HomeScreen(this);
        this.passwordReset = new PasswordResetScreen(this);
        digitConfirmationScreen = new DigitConfirmationScreen(this);
    }

    public void redirectToRegister(){
        authenticationScreen.hideScreen();
        registerScreen.makeVisible();
    }

    public void redirectToForgottenPass(){
        authenticationScreen.hideScreen();
        emailForm.makeVisible();
    }

    public void redirectToHomeScreen(){
        authenticationScreen.hideScreen();
        homeScreen.makeVisible();
    }

    public void redirectToHomeScreenFromPassReset(){
        passwordReset.hideScreen();
        homeScreen.makeVisible();
    }

    public void startNavigation () {
        authenticationScreen.makeVisible();
    }

    public void redirectToDigitConformation() {
        emailForm.hideScreen();
        digitConfirmationScreen.makeVisible();
    }

    public void redirectToPassReset() {
        digitConfirmationScreen.hideScreen();
        passwordReset.makeVisible();
    }
}