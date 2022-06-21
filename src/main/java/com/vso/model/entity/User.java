package com.vso.model.entity;

import java.io.Serializable;

public class User implements Serializable {
    private static int userCount = 0;
    private final String email;
    private final String password;
    private int age;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        userCount++;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

}
