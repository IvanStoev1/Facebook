package com.vso.view.changeProfileData;

import com.vso.model.service.changeProfileData.EmailReset;
import com.vso.model.service.changeProfileData.EmailResetImpl;
import com.vso.model.service.changeProfileData.ProfileDataServiceImpl;
import com.vso.view.BaseScreen;
import com.vso.view.Message;
import com.vso.view.Navigation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmailDigitConfScreen extends BaseScreen {

    private final Navigation navigation;

    public EmailDigitConfScreen(Navigation navigation) {
        this.navigation = navigation;
    }

    @Override
    protected LayoutManager getLayoutManager() {
        return new GridBagLayout();
    }

    @Override
    protected void setupComponents() {
        getContentPanel().setLayout(getLayoutManager());

        JLabel label = new JLabel("Digit you received on your E-mail: ");
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 50, 0, 5);
        getContentPanel().add(label, c);

        JTextField digit = new JTextField(11);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.insets = new Insets(0, 5, 0, 50);
        c.gridx = 1;
        c.gridy = 0;
        getContentPanel().add(digit, c);

        JButton submitBtn = new JButton("Submit");
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        c.ipadx = 2;
        c.ipady = 2;
        c.gridwidth = 0;
        c.insets = new Insets(5, 0, 30, 0);
        getContentPanel().add(submitBtn, c);

        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmailReset emailReset = new EmailResetImpl();
                if  ( emailReset.numbersMatch(digit.getText())){
                    new Message("Reset approved!");
                    new ProfileDataServiceImpl(emailReset).changeEmail(ChangeEmailScreen.getNewEmail());
                    navigation.redirectToHomeScreen();
                } else {
                    new Message("Numbers mismatch!");
                }
            }
        });
    }
}
