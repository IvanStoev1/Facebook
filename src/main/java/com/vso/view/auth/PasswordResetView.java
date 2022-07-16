package com.vso.view.auth;

public class PasswordResetView {

    public void declineReset() {
        System.out.println("Verification number and input number don't match.");
    }

    public void approveReset() {
        System.out.println("Password reset successfully!");
    }
}
