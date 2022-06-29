package com.vso.model.entity;

import jakarta.persistence.*;

import java.util.List;

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

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
