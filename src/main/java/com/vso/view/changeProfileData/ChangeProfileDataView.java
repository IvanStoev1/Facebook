package com.vso.view.changeProfileData;

import javax.swing.*;

public class ChangeProfileDataView extends JFrame {

    public ChangeProfileDataView() {
    }

    public void showInvalidInput(){
        JOptionPane.showMessageDialog(this,
                "Invalid input");
    }
    public void showSuccessfulReset(){
        JOptionPane.showMessageDialog(this,
                "Password reset successful");
    }

    public void showPasswordMismatch(){
        JOptionPane.showMessageDialog(this,
                "Passwords mismatch");
    }

}

