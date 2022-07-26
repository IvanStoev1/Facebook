package com.vso.model.entity;

import com.vso.model.enumaration.PostPrivacyStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.type.descriptor.java.LocalDateJavaType;
import org.hibernate.type.descriptor.java.LocalDateTimeJavaType;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private LocalDate date;
    @Column
    private String text;
    @Column
    private Date reported;
    @Column
    private Date deleted;

    public void setPrivacy_status(PostPrivacyStatus privacy_status) {
        this.privacy_status = privacy_status;
    }
    @Enumerated(EnumType.STRING)
    @Column
    private PostPrivacyStatus privacy_status;

    @ManyToOne(targetEntity = User.class)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "parent_post_id")
    private Post parentPost;

    @OneToMany(mappedBy = "parentPost", fetch = FetchType.EAGER)
    private Set<Post> comments;

    @ManyToMany(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinTable(name = "likes",
            joinColumns = {@JoinColumn(name = "post_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<User> likes;

    public Post() {
    }


    public Post(String text, User user) {
        this.text = text;
        this.user = user;
    }

    public void setLikes(Set<User> likes) {
        this.likes = likes;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public Date getReported() {
        return reported;
    }

    public Date getDeleted() {
        return deleted;
    }

    public PostPrivacyStatus getPrivacy_status() {
        return privacy_status;
    }

    public User getUser() {
        return user;
    }

    public Post getParentPost() {
        return parentPost;
    }

    public Set<Post> getComments() {
        return comments;
    }

    public Set<User> getLikes() {
        return likes;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setReported(Date reported) {
        this.reported = reported;
    }

    public void setDeleted(Date deleted) {
        this.deleted = deleted;
    }
}
