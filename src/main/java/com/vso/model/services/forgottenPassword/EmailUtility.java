package com.vso.model.services.forgottenPassword;

public interface EmailUtility {
    void sendEmail(String to, String subject, String content);
}
