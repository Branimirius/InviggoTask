package com.example.advertisementsbackend.dto;

import javax.persistence.Column;
import java.time.LocalDateTime;

public class AdvertisementDTO {
    private long id;
    private String name;
    private String description;
    private String photoUrl;
    private Double price;
    private String category;
    private long userId;
    private String city;
    private LocalDateTime dateCreated;

    public AdvertisementDTO(long id, String name, String description, String photoUrl, Double price, String category, long userId, String city, LocalDateTime dateCreated) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.photoUrl = photoUrl;
        this.price = price;
        this.category = category;
        this.userId = userId;
        this.city = city;
        this.dateCreated = dateCreated;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }
}
