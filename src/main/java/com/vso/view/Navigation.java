package com.vso.view;

import com.vso.view.auth.AuthenticationScreen;
import com.vso.view.auth.ForgottenPassScreen;
import com.vso.view.auth.RegisterScreen;
import com.vso.view.avatarView.AvatarView;
import com.vso.view.profileView.ProfileView;
import com.vso.view.uploadPhotoView.UploadView;

public class Navigation {

    private final AuthenticationScreen authenticationScreen;
    private final RegisterScreen registerScreen;
    private final ForgottenPassScreen forgottenPassScreen;
    private final HomeScreen homeScreen;
    private final UploadView uploadView;
    private final AvatarView avatarView;
    private final ProfileView profileView;

    public Navigation() {
        this.authenticationScreen = new AuthenticationScreen(
                this::redirectToRegister,
                this::redirectToForgottenPass,
                this::redirectToHomeScreen
        );
        this.registerScreen = new RegisterScreen(this);
        this.forgottenPassScreen = new ForgottenPassScreen(this);
        this.homeScreen = new HomeScreen(
                this::redirectToUploadView,
                this::redirectToAvatarView,
                this::redirectToProfile);
        this.uploadView = new UploadView(this::redirectUploadToHome);
        this.avatarView = new AvatarView(this::redirectFromAvatarToHome);
        this.profileView = new ProfileView(this::redirectFromProfileToHome);
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

    private void redirectUploadToHome(){
        uploadView.hideScreen();
        homeScreen.makeVisible();
    }

    private void redirectToUploadView(){
        homeScreen.hideScreen();
        uploadView.makeVisible();
    }

    private void redirectToAvatarView(){
        homeScreen.hideScreen();
        avatarView.makeVisible();
    }

    private void redirectFromAvatarToHome(){
        avatarView.hideScreen();
        homeScreen.makeVisible();
    }

    private void redirectToProfile(){
        profileView.makeVisible();
        homeScreen.hideScreen();
    }

    private void redirectFromProfileToHome(){
        homeScreen.makeVisible();
        profileView.hideScreen();
    }

    public void startNavigation () {
        authenticationScreen.makeVisible();
    }

}