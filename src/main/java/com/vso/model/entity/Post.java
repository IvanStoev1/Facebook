package com.vso.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {

    @ManyToOne(targetEntity = User.class)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(targetEntity = likes.class,mappedBy = "post",cascade=CascadeType.ALL)
    private List<likes> likesList;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column(insertable = false,updatable = false)
    private int user_id;
    @Column
    private Date date;
    @Column
    private String text;
   // @OneToMany(targetEntity = Post.class,mappedBy = "id")
    @Column
    private int parent_post_id;
    @Column
    private Date reported;
    @Column
    private Date deleted;
    @Column
    private String privacy_status;

    public Post() {
    }
}
