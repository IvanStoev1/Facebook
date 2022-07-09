package com.vso.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "photos")
public class Photos {

    @ManyToOne(targetEntity = User.class)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column(insertable = false,updatable = false)
    private long user_id;
    @Column
    private String description;
    @Column
    private String url;

    public Photos() {
    }

    public Photos( long user_id, String description, String url) {
        this.user = new User();
        this.user_id = user_id;
        this.description = description;
        this.url = url;
    }
}
