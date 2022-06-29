package com.vso.model.service;

import java.util.Scanner;

public class CommunicationImpl implements Communication {
    private final Scanner scanner;

    public CommunicationImpl() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void show(String text) {
        System.out.println(text);
    }

    @Override
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


    @Override
    public String getTextInput() {
        return scanner.nextLine();
    }
}