package com.vso.model.services.forgottenPassword;

public class Email {

    private String subject;
    private String content;
    private String verificationNumber;

    public Email(String subject, String content, String verificationNumber) {
        this.content = content;
        this.subject = subject;
        this.verificationNumber = verificationNumber;
    }

    public Email(String content, String subject) {
        this.content = content;
        this.subject = subject;
    }

    public String getVerificationNumber() {
        return verificationNumber;
    }
}