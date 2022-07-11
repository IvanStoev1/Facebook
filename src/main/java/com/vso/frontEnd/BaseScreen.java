package com.vso.frontEnd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaseScreen extends JFrame implements ActionListener{

    JTextField password;
    JTextField email;
    JButton button;

    public BaseScreen(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BoxLayout(getContentPane(),BoxLayout.LINE_AXIS));
        this.setSize(500,500);

        this.add(getLoginButton());
        this.add(getEmailField());
        this.add(getPasswordField());

        this.pack();
        this.setVisible(true);

    }

    public JTextField getEmailField(){
        email = new JTextField();
        email.setPreferredSize(new Dimension(250,40));
        return email;
    }

    public JButton getLoginButton(){
        button = new JButton("Login");
        button.setBounds(200,100,100,50);
        button.addActionListener(this);
        return button;
    }

    public JTextField getPasswordField(){
        password = new JTextField();
        password.setPreferredSize(new Dimension(250,400));
        return password;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == getLoginButton()){
            System.out.println(getPasswordField().getText());
        }

    }

}
