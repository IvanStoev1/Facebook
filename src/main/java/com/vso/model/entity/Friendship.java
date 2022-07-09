package com.vso.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.lang.annotation.Target;

@Entity
@Table(name = "friendships")
public class Friendship {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String friendship_status;

    @ManyToOne(targetEntity = User.class)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "user_id_requester")
    private User requester;

    @ManyToOne(targetEntity = User.class)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "user_id_requested")
    private User requested;

    public Friendship() {
    }

    public Friendship(User requester, User requested, String friendship_status) {
        this.requester = requester;
        this.requested = requested;
        this.friendship_status = friendship_status;
    }

    public long getId() {
        return id;
    }

    public String getFriendship_status() {
        return friendship_status;
    }

    public User getRequester() {
        return requester;
    }

    public User getRequested() {
        return requested;
    }
}
