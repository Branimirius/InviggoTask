package com.example.advertisementsbackend.controller;

import com.example.advertisementsbackend.model.Advertisement;
import com.example.advertisementsbackend.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api")
public class AdvertisementController {
    @Autowired
    private AdvertisementService adService;


    //get users
    @GetMapping(value = "/ads")
    public List<Advertisement> getAllAds(){
        return this.adService.findAll();
    }

    //get user by id
    @GetMapping(value = "/ads/{id}")
    public ResponseEntity<Advertisement> getAdOne(@PathVariable(value = "id") Long adId) {
        Advertisement ad = adService.findOne(adId);
        return ResponseEntity.ok().body(ad);
    }



    //save user
    /*
    @PostMapping(value = "/users", consumes = "application/json")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {

        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setDateJoined(userDTO.getDateJoined());
        user.setPhone(userDTO.getPhone());
        user = userService.save(user);
        return new ResponseEntity<>(new UserDTO(user), HttpStatus.CREATED);
    }*/

    /*update user
    @PutMapping(value = "/users", consumes = "application/json")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO) {
        System.out.println("UPDATE: " + userDTO.getId() + " " + userDTO.getUsername());
        User user = userService.findOne(userDTO.getId());

        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setDateJoined(userDTO.getDateJoined());
        user.setPhone(userDTO.getPhone());
        user = userService.save(user);
        return new ResponseEntity<>(new UserDTO(user), HttpStatus.CREATED);
    }*/

    /* delete user
    @DeleteMapping(value = "/users/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") long userId) {
        this.userService.remove(userId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
    */




}
