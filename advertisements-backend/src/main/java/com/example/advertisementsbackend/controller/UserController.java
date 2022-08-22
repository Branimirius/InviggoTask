package com.example.advertisementsbackend.controller;

import com.example.advertisementsbackend.dto.UserDTO;
import com.example.advertisementsbackend.dto.UserLoginDTO;
import com.example.advertisementsbackend.model.User;
import com.example.advertisementsbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api")
public class UserController {
    @Autowired
    private UserService userService;


    //get users
    @GetMapping(value = "/users")
    public List<User> getAllUsers(){
        return this.userService.findAll();
    }

    //get user by id
    @GetMapping(value = "/users/{id}")
    public ResponseEntity<User> getUserOne(@PathVariable(value = "id") Long userId) {
        User user = userService.findOne(userId);
        return ResponseEntity.ok().body(user);
    }



    //save user

    @PostMapping(value = "/users", consumes = "application/json")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {

        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setDateJoined(userDTO.getDateJoined());
        user.setPhone(userDTO.getPhone());
        user = userService.save(user);
        return new ResponseEntity<>(new UserDTO(user), HttpStatus.CREATED);
    }

    //update user
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
    }

    //delete user
    @DeleteMapping(value = "/users/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") long userId) {
        this.userService.remove(userId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }

    @PostMapping(value = "/authenticate", consumes = "application/json")
    public ResponseEntity<User> loginUser(@RequestBody UserLoginDTO userLoginDTO) {
        System.out.println("KONTROLA 1: " + userLoginDTO.getUsername() + " " + userLoginDTO.getPassword());
        User user = userService.findOneByLogin(userLoginDTO.getUsername(), userLoginDTO.getPassword());
        if((userService.findOneByLogin(userLoginDTO.getUsername(), userLoginDTO.getPassword()) != null)) {
            System.out.println("KONTROLA 3: " + user.getUsername() + " " + user.getPassword());
            return ResponseEntity.ok().body(user);
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        //return ResponseEntity.ok().body(user);
    }



}
