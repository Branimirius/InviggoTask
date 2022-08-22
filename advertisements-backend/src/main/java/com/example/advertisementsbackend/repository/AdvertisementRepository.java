package com.example.advertisementsbackend.repository;

import com.example.advertisementsbackend.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Integer> {
}
