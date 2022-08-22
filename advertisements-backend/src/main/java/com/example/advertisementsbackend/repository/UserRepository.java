package com.example.advertisementsbackend.repository;

import com.example.advertisementsbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
