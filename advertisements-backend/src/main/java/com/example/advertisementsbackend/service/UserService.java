package com.example.advertisementsbackend.service;

import java.util.List;

import com.example.advertisementsbackend.model.User;
import com.example.advertisementsbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findOne(long id) {
        return userRepository.findById((int)id).orElseGet(null);
    }

    public User findOneByLogin(String username, String pass) {
        List<User> allUsers = findAll();
        for(User u : allUsers) {
            if((u.getUsername().equals(username) ) && (u.getPassword().equals(pass))) {
                return u;
            }
        }
        return null;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Page<User> findAll(Pageable page) {
        return userRepository.findAll(page);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void remove(long id) {
        userRepository.deleteById((int)id);
    }


}
