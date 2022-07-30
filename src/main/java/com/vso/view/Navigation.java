package com.vso.view;

//import com.vso.view.profile.LikeCommentPost;
import com.vso.view.profile.GallerySection;
//import com.vso.view.profile.LikePostSection;
import com.vso.view.requests.Requests;
import com.vso.view.search.Search;
import com.vso.view.auth.AuthenticationScreen;
import com.vso.view.changeProfileData.*;
import com.vso.view.forgottenPassword.DigitConfirmationScreen;
import com.vso.view.forgottenPassword.EmailFormScreen;
import com.vso.view.auth.RegisterScreen;
import com.vso.view.profile.MyProfileView;
import com.vso.view.search.SearchResultSet;
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
    private final Search search;
    private final Requests requests;
    private final SearchResultSet searchResultSet;
    private final GallerySection gallerySection;
    private final ProfileDataScreen profileDataScreen;
    private final LoginScreen loginScreen;
    private final ChangeEmailScreen emailScreen;
    private final ChangePasswordScreen changePasswordScreen;
    private final EmailDigitConfScreen emailDigitConfScreen;

    public Navigation() {
        this.authenticationScreen = new AuthenticationScreen(
                this::redirectToRegister,
                this::redirectToForgottenPass,
                this::redirectToHomeScreen
        );
        this.registerScreen = new RegisterScreen(this::redirectRegisterToLogin);
        this.emailForm = new EmailFormScreen(this);
        this.homeScreen = new HomeScreen(this);
        this.uploadView = new UploadView(this::redirectUploadToHome);
        this.myProfileView = new MyProfileView(this);
        this.passwordReset = new PasswordResetScreen(this);
        this.digitConfirmationScreen = new DigitConfirmationScreen(this);
        this.search = new Search(this);
        this.requests = new Requests(this);
        this.searchResultSet = new SearchResultSet(this);
        this.gallerySection = new GallerySection();
        this.profileDataScreen = new ProfileDataScreen(this);
        this.loginScreen = new LoginScreen(this);
        this.emailScreen = new ChangeEmailScreen(this);
        this.changePasswordScreen = new ChangePasswordScreen(this);
        this.emailDigitConfScreen = new EmailDigitConfScreen(this);
    }


    public void redirectFromHomeToRequests() {
        homeScreen.hideScreen();
        requests.setComponents();
        requests.makeVisible();

    }

    public void redirectFromProfileToLogin() {
        myProfileView.dispose();
        authenticationScreen.makeVisible();
    }

    public void redirectFromSearchToHome() {
        search.dispose();
        homeScreen.makeVisible();
    }

    public void redirectFromHomeToLogin() {
        homeScreen.dispose();
        authenticationScreen.makeVisible();
    }

    public void redirectRegisterToLogin() {
        registerScreen.hideScreen();
        authenticationScreen.makeVisible();
    }

    public void redirectToRegister() {
        authenticationScreen.hideScreen();
        registerScreen.makeVisible();
    }

    public void redirectToForgottenPass() {
        authenticationScreen.hideScreen();
        emailForm.makeVisible();
    }

    public void redirectToHomeScreen() {
        authenticationScreen.hideScreen();
        homeScreen.makeVisible();
    }

    public void redirectUploadToHome() {
        uploadView.hideScreen();
        homeScreen.makeVisible();
    }

    public void redirectFromHomeToUploadView() {
        homeScreen.hideScreen();
        uploadView.makeVisible();
    }

    public void redirectFromProfileToHome() {
        homeScreen.makeVisible();
        myProfileView.hideScreen();
    }

    public void redirectToHomeScreenFromPassReset() {
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

    public void redirectToLoginScreen() {
        profileDataScreen.hideScreen();
        loginScreen.makeVisible();
    }

    public void redirectToChangeEmailScreen() {
        profileDataScreen.hideScreen();
        emailScreen.makeVisible();
    }


    public void redirectToProfileDataScreen() {
        authenticationScreen.hideScreen();
        profileDataScreen.makeVisible();
    }

    public void redirectToChangePasswordScreen() {
        loginScreen.hideScreen();
        changePasswordScreen.makeVisible();
    }


    public void redirectToEmailDigitConformation() {
        emailScreen.hideScreen();
        emailDigitConfScreen.makeVisible();

        public void startNavigation() {
            authenticationScreen.makeVisible();
        }
    }
}