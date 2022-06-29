package com.vso.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.lang.annotation.Target;

@Entity
@Table(name = "friendships")
public class Friendships {

    @ManyToOne(targetEntity = User.class)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "user_id",insertable = false,updatable = false)
    private User requester;

    @ManyToOne(targetEntity = User.class)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "user_id",insertable = false,updatable = false)
    private User requested;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private long user_id_requester;
    @Column
    private long user_id_requested;
    @Column
    private String friendship_status;

    public Friendships() {
    }

    public Friendships(User requester,User requested,long user_id_requester, long user_id_requested, String friendship_status) {
        this.requester = requester;
        this.requested = requested;
        this.user_id_requester = user_id_requester;
        this.user_id_requested = user_id_requested;
        this.friendship_status = friendship_status;
    }
}
