package com.vso.model.service.forgottenPassword;

public class Email {

    private final String subject;
    private final String content;
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