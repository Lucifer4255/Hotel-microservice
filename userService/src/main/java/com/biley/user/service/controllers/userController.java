package com.biley.user.service.controllers;

import com.biley.user.service.Services.UserService;
import com.biley.user.service.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class userController {

    @Autowired
    private UserService userService;

    //create
    @PostMapping
    public ResponseEntity<User>createUser(@RequestBody User user){
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    //get all users
    @GetMapping
    public ResponseEntity<List<User>>getAllUsers(){
        List<User> allUser = userService.getAllUsers();
        return ResponseEntity.ok(allUser);
    }

    //get user by id

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId){
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

}
