package com.biley.user.service.Services;

import com.biley.user.service.entities.User;

import java.util.List;

public interface UserService {

    //User Operations

    //create
    User saveUser(User user);

    //get users
    List<User> getAllUsers();

    User getUserById(String userId);

}
