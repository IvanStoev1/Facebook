package com.vso.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "avatar_url")
    private String avatarUrl;
    @Column(name = "cover_url")
    private String isCompleted;
    @Column(name = "profile_status")
    private String profileStatus;
    @Column(name = "profile_role")
    private String profileRole;
    @Column(name = "last_verification_number")
    private int lastSentNumber;

    @OneToMany(targetEntity = Post.class, mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts;

    @OneToMany(targetEntity = Photo.class, mappedBy = "user", cascade = CascadeType.ALL)
    private List<Photo> photos;

    public User(String email,String password,String name, int age, String avatarUrl) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
        this.avatarUrl = avatarUrl;
    }

    public User() {

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
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

    public List<Post> getPosts() {
        return posts;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public String toString() {
        return "<html>My info:<br> " +
                "\n email<br> " + email +
                "\n name<br> " + name +
                "\n age<br> " + age;
    }

    public int getLastSentNumber() {
        return lastSentNumber;
    }
}
