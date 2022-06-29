package com.vso.model.services.forgottenPassword;

import com.vso.model.entity.User;

import java.util.Scanner;

public class PasswordReset {

    private Scanner scanner;
    private User user;
    private Email email;

    public PasswordReset(User user, Email email) {
        this.scanner = new Scanner(System.in);
        this.user = user;
        this.email = email;
    }

    public void reset() {
        System.out.println("Your 5-digit verification number: ");
        String number = scanner.nextLine();
        if(number.equals(email.getVerificationNumber())) {
            approveReset();
        } else {
            declineReset();
        }
    }

    private void approveReset() {
        System.out.println("New password: ");
        String password = scanner.nextLine();
        user.setPassword(password);
        System.out.println("Password reset successfully!");
    }

    private void declineReset() {
        System.out.println("Verification number and input number don't match.");
    }
}
