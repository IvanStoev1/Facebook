package com.vso.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @ManyToOne(targetEntity = User.class)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(targetEntity = Post.class)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "post_id")
    private Post post;

    public Like(User user, Post post) {
        this.user = user;
        this.post = post;
        post.getLikes().add(this.user);
    }

    public Like() {

    }
}
