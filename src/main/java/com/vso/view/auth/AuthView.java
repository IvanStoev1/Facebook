package com.vso.view.auth;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class AuthView extends JFrame {

    public AuthView() {
    }

    public void showLoginFail(){
        JOptionPane.showMessageDialog(this,
                "Login failed");
    }
    public void showRegisterFail(){
        JOptionPane.showMessageDialog(this,
                "You must be 14 or older to make an account");
    }
}