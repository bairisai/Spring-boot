package com.app.ecom.service;

import com.app.ecom.model.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    public List<User> fetchAllUsers();
    public void addUser(User user);
    public Optional<User> fetchUserById(Long id);
    public boolean updateUserById(Long id, User user);
}
