package com.app.ecom.service;

import com.app.ecom.User.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    public List<User> fetchAllUsers();
    public void addUser(User user);
}
