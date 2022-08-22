package com.example.advertisementsbackend.model;

import com.example.advertisementsbackend.enums.Category;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity(name = "advertisements")
@Table(name = "advertisements")
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "price")
    private Double price;

    @Column(name = "category")
    private String category;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "city")
    private String city;

    @Column(name = "date_created")
    private LocalDateTime dateCreated;


}
