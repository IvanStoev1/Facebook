package com.vso.model.service;

public class Forms {
    private final Communication communicationManager;

    public Forms() {
        this.communicationManager = new CommunicationImpl();
    }

    public String[] processForm() {
        communicationManager.show("Enter age");
        int age = communicationManager.getNumberInput();
        while(age < 14){
            communicationManager.show("You need to be 14 or older to make an account");
            age = communicationManager.getNumberInput();
        }
        communicationManager.show("Enter name");
        String name = communicationManager.getTextInput();
        communicationManager.show("Enter email:");
        String email = communicationManager.getTextInput();
        communicationManager.show("Enter password:");
        String password = communicationManager.getTextInput();
        communicationManager.show("Enter password again:");
        String repeatPassword = communicationManager.getTextInput();
        return new String[]{String.valueOf(age),name,email, password, repeatPassword};
    }

    public String[] processLoginForm() {
        communicationManager.show("Enter email:");
        String email = communicationManager.getTextInput();
        communicationManager.show("Enter password:");
        String password = communicationManager.getTextInput();
        return new String[]{email, password};
    }
}

