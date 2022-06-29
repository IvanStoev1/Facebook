package com.vso.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column
    private long id;
    @Column(name = "email")
    String email;
    @Column(name = "password")
    String password;
    @Column(name = "name")
    String name;
    @Column(name = "age")
    int age;
    @Column(name = "avatar_url")
    String avatarUrl;
    @Column(name = "cover_url")
    String isCompleted;
    @Column(name = "profile_status")
    String profileStatus;
    @Column(name = "profile_role")
    String profileRole;

    public User(String email,String password,String name, int age) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    public User(int iD) {
        this.id = iD;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getIsCompleted() {
        return isCompleted;
    }

    public String getProfileStatus() {
        return profileStatus;
    }

    public String getProfileRole() {
        return profileRole;
    }

}
