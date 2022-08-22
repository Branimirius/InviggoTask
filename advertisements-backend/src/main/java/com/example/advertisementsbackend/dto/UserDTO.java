package com.example.advertisementsbackend.dto;

import com.example.advertisementsbackend.model.User;

import javax.persistence.Column;
import java.time.LocalDateTime;

public class UserDTO {
    private long id;
    private String username;
    private String password;
    private LocalDateTime dateJoined;
    private String phone;

    public UserDTO(long id, String username, String password, LocalDateTime dateJoined, String phone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.dateJoined = dateJoined;
        this.phone = phone;
    }

    public UserDTO(User user){
        this.id = user.getId();
        this.dateJoined = user.getDateJoined();
        this.password = user.getPassword();
        this.phone = user.getPhone();
        this.username = user.getUsername();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(LocalDateTime dateJoined) {
        this.dateJoined = dateJoined;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
