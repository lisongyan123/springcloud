package com.example.webflux.controller.domain;

public class User {
    String id;
    String name;

    public User() {
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}