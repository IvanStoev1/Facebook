package com.vso.view.changeprofiledata;

import com.vso.view.BaseScreen;
import com.vso.view.Navigation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmailScreen extends BaseScreen {

    private Navigation navigation;

    public AddEmailScreen(Navigation navigation) {
        this.navigation = navigation;
    }

    @Override
    protected LayoutManager getLayoutManager() {
        return new GridBagLayout();
    }

    @Override
    protected void setupComponents() {
        getContentPanel().setLayout(getLayoutManager());

        JLabel instruction1 = new JLabel("Add email address:");
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 50, 0, 5);
        getContentPanel().add(instruction1, c);

        JTextField emailField = new JTextField(11);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.insets = new Insets(0, 5, 0, 50);
        c.gridx = 1;
        c.gridy = 1;
        getContentPanel().add(emailField, c);

        JButton addEmailBtn = new JButton("Add Email Address");
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        c.ipadx = 5;
        c.ipady = 5;
        c.gridwidth = 0;
        c.insets = new Insets(70, 0, 0, 140);
        getContentPanel().add(addEmailBtn, c);

        addEmailBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
