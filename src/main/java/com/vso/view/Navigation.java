package com.vso.view;

import com.vso.view.auth.AuthenticationScreen;
import com.vso.view.forgottenPassword.DigitConfirmationScreen;
import com.vso.view.forgottenPassword.EmailFormScreen;
import com.vso.view.auth.RegisterScreen;
import com.vso.view.profile.MyProfileView;
import com.vso.view.uploadphoto.UploadView;
import com.vso.view.forgottenPassword.PasswordResetScreen;

public class Navigation {

    private final AuthenticationScreen authenticationScreen;
    private final RegisterScreen registerScreen;
    private final EmailFormScreen emailForm;
    private final HomeScreen homeScreen;
    private final UploadView uploadView;
    private final MyProfileView myProfileView;
    private final PasswordResetScreen passwordReset;
    private final DigitConfirmationScreen digitConfirmationScreen;

    public Navigation() {
        this.authenticationScreen = new AuthenticationScreen(
                this::redirectToRegister,
                this::redirectToForgottenPass,
                this::redirectToHomeScreen
        );
        this.registerScreen = new RegisterScreen(this::redirectRegisterToLogin);
        this.emailForm = new EmailFormScreen(this);
        this.homeScreen = new HomeScreen(
                this::redirectToUploadView,
                this::redirectToProfile);
        this.uploadView = new UploadView(this::redirectUploadToHome);
        this.myProfileView = new MyProfileView(
                this::redirectFromProfileToHome);
        this.passwordReset = new PasswordResetScreen(this);
        this.digitConfirmationScreen = new DigitConfirmationScreen(this);
    }

    public void redirectRegisterToLogin(){
        registerScreen.hideScreen();
        authenticationScreen.makeVisible();
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

    private void redirectUploadToHome(){
        uploadView.hideScreen();
        homeScreen.makeVisible();
    }

    private void redirectToUploadView(){
        homeScreen.hideScreen();
        uploadView.makeVisible();
    }

    private void redirectToProfile(){
        myProfileView.makeVisible();
        myProfileView.setComponents();
        homeScreen.hideScreen();
    }

    private void redirectFromProfileToHome(){
        homeScreen.makeVisible();
        myProfileView.hideScreen();
    }

    public void redirectToHomeScreenFromPassReset(){
        passwordReset.hideScreen();
        homeScreen.makeVisible();
    }

    public void redirectToDigitConformation() {
        emailForm.hideScreen();
        digitConfirmationScreen.makeVisible();
    }

    public void redirectToPassReset() {
        digitConfirmationScreen.hideScreen();
        passwordReset.makeVisible();
    }

    public void startNavigation () {
        authenticationScreen.makeVisible();
    }

}