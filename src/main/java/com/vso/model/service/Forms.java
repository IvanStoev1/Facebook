package com.vso.model.service;

public class Forms {
    private final Communication communicationManager;

    public Forms() {
        this.communicationManager = new CommunicationImpl();
    }

    public String[] processForm() {
        communicationManager.show("Enter email:");
        String email = communicationManager.getTextInput();
        communicationManager.show("Enter password:");
        String password = communicationManager.getTextInput();
        communicationManager.show("Enter password again:");
        String repeatPassword = communicationManager.getTextInput();
        return new String[]{email, password, repeatPassword};
    }

    public String[] processLoginForm() {
        communicationManager.show("Enter email:");
        String email = communicationManager.getTextInput();
        communicationManager.show("Enter password:");
        String password = communicationManager.getTextInput();
        return new String[]{email, password};
    }
}

