package com.vso.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "likes")
public class likes {

    @ManyToOne(targetEntity = User.class)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "user_id",insertable = false,updatable = false)
    private User user;


    @ManyToOne(targetEntity = Post.class)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "post_id",insertable = false,updatable = false)
    private Post post;

    @Column
    private long post_id;
    @Id
    @Column
    private long user_id;

    public likes() {
    }


}
