package com.vso.model.entity;

import com.vso.model.service.authentication.AuthenticationServiceImpl;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "photos")
public class Photo {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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


    public Photo() {
    }

    public Photo(String description, String url) {
        this.user = AuthenticationServiceImpl.getLoggedUser();
        this.description = description;
        this.url = url;
    }

    public Long getId() {
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
