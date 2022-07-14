package com.vso.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "photos")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(insertable = false,updatable = false)
    private long user_id;
    @Column
    private String description;
    @Column
    private String url;

    @ManyToOne(targetEntity = User.class)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "user_id")
    private User user;


    public Photo() {
    }

    public Photo(long user_id, String description, String url) {
        this.user = new User();
        this.user_id = user_id;
        this.description = description;
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public long getUser_id() {
        return user_id;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public User getUser() {
        return user;
    }
}
