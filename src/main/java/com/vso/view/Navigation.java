package com.vso.view;

import com.vso.view.auth.AuthenticationScreen;
import com.vso.view.changeProfileData.*;
import com.vso.view.forgottenPassword.DigitConfirmationScreen;
import com.vso.view.forgottenPassword.EmailFormScreen;
import com.vso.view.auth.RegisterScreen;
import com.vso.view.profile.ProfileView;
import com.vso.view.uploadphoto.UploadView;
import com.vso.view.forgottenPassword.PasswordResetScreen;

public class Navigation {

    private final AuthenticationScreen authenticationScreen;
    private final RegisterScreen registerScreen;
    private final EmailFormScreen emailForm;
    private final HomeScreen homeScreen;
    private final UploadView uploadView;
    private final ProfileView profileView;
    private final PasswordResetScreen passwordReset;
    private final DigitConfirmationScreen digitConfirmationScreen;
    private final ProfileDataScreen profileDataScreen;
    private final LoginScreen loginScreen;
    private final ChangeEmailScreen emailScreen;
    private final AddEmailScreen addEmailScreen;
    private final ChangePasswordScreen changePasswordScreen;
  //  private final NewAvatarSection newAvatarSection;



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
      //  this.avatarView = new AvatarView(this::redirectFromAvatarToHome);
        this.profileDataScreen = new ProfileDataScreen(this);
        this.loginScreen = new LoginScreen(this);
        this.emailScreen = new ChangeEmailScreen(this);
        this.addEmailScreen = new AddEmailScreen(this);
        this.changePasswordScreen = new ChangePasswordScreen(this);

        this.profileView = new ProfileView(
                this::redirectFromProfileToHome,
                this::redirectToNewAvatar);
        this.passwordReset = new PasswordResetScreen(this);
        this.digitConfirmationScreen = new DigitConfirmationScreen(this);
      //  this.newAvatarSection = new NewAvatarSection(this::redirectFromNewAvatarToProfile);
    }

    public void redirectFromNewAvatarToProfile(){
       // newAvatarSection.hideScreen();
        profileView.makeVisible();
    }

    public void redirectToNewAvatar(){
        profileView.hideScreen();
      //  newAvatarSection.makeVisible();
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
        profileView.makeVisible();
        profileView.setComponents();
        homeScreen.hideScreen();
    }

    private void redirectFromProfileToHome(){
        homeScreen.makeVisible();
        profileView.hideScreen();
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

    public void redirectToLoginScreen() {
        profileDataScreen.hideScreen();
        loginScreen.makeVisible();
    }

    public void redirectToChangeEmailScreen() {
        profileDataScreen.hideScreen();
        emailScreen.makeVisible();
    }


    public void redirectToProfileDataScreen(){
        authenticationScreen.hideScreen();
        profileDataScreen.makeVisible();
    }

    public void redirectToChangePasswordScreen(){
        loginScreen.hideScreen();
        changePasswordScreen.makeVisible();
    }
}