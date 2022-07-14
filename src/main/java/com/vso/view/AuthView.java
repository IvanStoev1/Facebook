package com.vso.view;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class AuthView extends JFrame {

    Scanner scanner;

    public AuthView() {
        this.scanner = new Scanner(System.in);
    }

    public void show(String text) {
        System.out.println(text);
    }

    public int getNumberInput() {
        int n;
        String input = scanner.nextLine();
        try {
            n = Integer.parseInt(input);
            if (n <= 0) {
                System.out.println("Enter a positive number");
                return getNumberInput();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, please enter a number");
            return getNumberInput();
        }
        return n;
    }
    public void showLoginFail() {
        JOptionPane.showMessageDialog(this,
                "Try again");
    }

    public String getTextInput() {
        return scanner.nextLine();
    }

    public String getNonRegisteredUserOptions() {
        return "1. Login\n" +
                "2. Register";
    }

    public String getUserOptions() {
        return "1. Logout\n" +
                "2.Upload post";

    }
}