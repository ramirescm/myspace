package com.myspace.dtos;

import com.myspace.entities.User;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private String id;
    private String name;
    private String email;

    public UserDTO() {
    }

    public UserDTO(User user) {
        setId(user.getId());
        setName(user.getName());
        setEmail(user.getEmail());
    }

    public User fromDTO() {
        return new User(this.getId(), this.getName(), this.getEmail());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
