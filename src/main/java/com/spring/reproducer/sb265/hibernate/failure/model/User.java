package com.spring.reproducer.sb265.hibernate.failure.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    private Long id;

    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public Long id() {
        return id;
    }

    public String name() {
        return name;
    }

    public User withName(String name) {
        this.name = name;
        return this;
    }
}
