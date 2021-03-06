package com.vso.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column
    private long id;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
