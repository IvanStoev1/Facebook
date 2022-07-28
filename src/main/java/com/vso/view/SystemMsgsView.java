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
                "You must be 14 or older to make an account");
    }

    public void showEmptyFileChooser(){
        JOptionPane.showMessageDialog(this,
                "No file was selected. Select file.");
    }

    public void showSuccessfulUpload(){
        JOptionPane.showMessageDialog(this,
                "Image was successfully uploaded.");
    }

    public void showLoggedUserIsNull() {
        JOptionPane.showMessageDialog(this,
                "Logged user is null.");
    }

    public void showRequestedUserIsNull() {
        JOptionPane.showMessageDialog(this,
                "Requested user is null.");
    }

    public void showAccountDeleted() {
        JOptionPane.showMessageDialog(this,
                "Your account was successfully deleted.");
    }

    public void showEmptyNameTextField() {
        JOptionPane.showMessageDialog(this,
                "Enter any name!");
    }
}