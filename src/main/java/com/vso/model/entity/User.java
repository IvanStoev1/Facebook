package com.vso.model.entity;

import jakarta.persistence.*;
<<<<<<< HEAD

import java.util.List;
=======
>>>>>>> 656a14378d066b2a7af27ecaa4daf1228bdaf9ae

@Entity
@Table(name = "users")
public class User {

    @OneToMany(targetEntity = Post.class,mappedBy = "user",cascade=CascadeType.ALL)
    private List<Post> postList;

    @OneToMany(targetEntity = Photos.class,mappedBy = "user",cascade=CascadeType.ALL)
    private List<Photos> photosList;

    @OneToMany(targetEntity = Friendships.class,mappedBy = "requester",cascade=CascadeType.ALL )
    private List<User> requestersList;

    @OneToMany(targetEntity = Friendships.class,mappedBy = "requested",cascade=CascadeType.ALL)
    private List<User> requestedList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
<<<<<<< HEAD
    private long id;
    @Column
    private String email;
    @Column
    private int pass;
    @Column
    private String name;
    @Column
    private int age;
    @Column
    private String avatar_url;
    @Column
    private String cover_url;
    @Column
    private String profile_status;
    @Column
    private String profile_role;
=======
    private int id;
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
>>>>>>> 656a14378d066b2a7af27ecaa4daf1228bdaf9ae

    public User() {
    }

    public int getId() {
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

    public void setPassword(String password) {
        this.password = password;
    }
}
