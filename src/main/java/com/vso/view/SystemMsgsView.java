package com.vso.view;

import javax.swing.*;

public class SystemMsgsView extends JFrame {

    public SystemMsgsView() {
    }

    public void showLoginFail(){
        JOptionPane.showMessageDialog(this,
                "Login failed");
    }
    public void showRegisterFail(){
        JOptionPane.showMessageDialog(this,
                "You must be 14 or older and fill out all the fields to make an account");
    }

    public void showEmptyFileChooser(){
        JOptionPane.showMessageDialog(this,
                "No file was selected. Select file.");
    }

    public void showSuccessfulUpload(){
        JOptionPane.showMessageDialog(this,
                "Image was successfully uploaded.");
    }
}