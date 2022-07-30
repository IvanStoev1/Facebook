package com.vso.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.Set;

@Entity
@Table(name = "photos")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(insertable = false,updatable = false)
    private Integer user_id;
    @Column (name = "description")
    private String description;
    @Column (name = "url")
    private String url;

    @ManyToOne(targetEntity = User.class)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "user_id")
    private User user;

//TODO TRYING TO SET LIKES FOR PHOTOS----------------------------------------
    @ManyToOne
    @JoinColumn(name = "parent_photo_id")
    private Photo parentPhoto;

    @OneToMany(mappedBy = "parentPhoto", fetch = FetchType.EAGER)
    private Set<Photo> comments;

    @ManyToMany(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinTable(name = "like_photos",
            joinColumns = {@JoinColumn(name = "photo_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<User> likes;

//TODO TRYING TO SET LIKES FOR PHOTOS----------------------------------------

    public Photo() {
    }

    public Photo(User user, String description, String url) {
        this.user = user;
        this.description = description;
        this.url = url;
    }

    public Photo getParentPhoto() {
        return parentPhoto;
    }

    public void setParentPhoto(Photo parentPhoto) {
        this.parentPhoto = parentPhoto;
    }

    public Set<Photo> getComments() {
        return comments;
    }

    public void setComments(Set<Photo> comments) {
        this.comments = comments;
    }

    public Set<User> getLikes() {
        return likes;
    }

    public void setLikes(Set<User> likes) {
        this.likes = likes;
    }

//TODO TRYING TO SET LIKES FOR PHOTOS----------------------------------------

    public Integer getId() {
        return id;
    }

    public Integer getUser_id() {
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

    public void setUser(User user) {
        this.user = user;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}