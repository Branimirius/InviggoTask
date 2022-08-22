package com.example.advertisementsbackend.service;

import com.example.advertisementsbackend.model.Advertisement;
import com.example.advertisementsbackend.model.User;
import com.example.advertisementsbackend.repository.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementService {
    @Autowired
    private AdvertisementRepository advertisementRepository;

    public Advertisement findOne(long id) {
        return advertisementRepository.findById((int)id).orElseGet(null);
    }

    public List<Advertisement> findAll() {
        return advertisementRepository.findAll();
    }

    public Page<Advertisement> findAll(Pageable page) {
        return advertisementRepository.findAll(page);
    }

    public Advertisement save(Advertisement user) {
        return advertisementRepository.save(user);
    }

    public void remove(long id) {
        advertisementRepository.deleteById((int)id);
    }
}
