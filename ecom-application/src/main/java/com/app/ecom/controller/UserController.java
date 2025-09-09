package com.app.ecom.controller;

import com.app.ecom.User.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    List<User> usersList = new ArrayList<User>();

    @GetMapping("/api/users")
    public List<User> getAllUsers() {
        return usersList;
    }

    @PostMapping("/api/users")
    public List<User> createUser(@RequestBody User user) {
        usersList.add(user);
        return usersList;
    }
}
