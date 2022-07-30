package com.vso.model.service.forgottenpassword;

import com.vso.model.dao.UserDao;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

public class EmailUtilityImpl implements EmailUtility {

    private final String host;
    private final int port;
    private final boolean debug;

    private final String senderEmail;
    private final String password;

    public EmailUtilityImpl() {
        host = "smtp.gmail.com";
        port = 587;
        debug = true;
        password = "wknjxhovbekwwpfi";
        senderEmail = "facebookjava2022@gmail.com";
    }

    @Override
    public void sendVerificationEmail(String to) {
        int number = new Random().nextInt(99999 - 10000 + 1) + 10000;
        String subject = "5-digit number verification";
        String content = "Your 5-digit number is : \n" + number;
        UserDao.getUserBy(to).setLastSentNumber(number);
        UserDao.setLastSentNumber(number,UserDao.getUserBy(to));
        sendEmail(to, subject, content);
    }

    private void sendEmail(String to, String subject, String content) {
        try {
            MimeMessage message = new MimeMessage(openSession());
            message.setFrom(new InternetAddress(senderEmail));
            message.setReplyTo(InternetAddress.parse(senderEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setContent(content, "text/html; charset=utf-8");
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private Session openSession() {
        return Session.getDefaultInstance(
                setProps(),
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(senderEmail, password);
                    }
                }
        );
    }

    private Properties setProps() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", debug);
        props.put("mail.smtp.socketFactory.port", port);
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.ssl.trust", host);
        return props;
    }
}