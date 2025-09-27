package com.app.ecom.service;

import com.app.ecom.dto.UserRequest;
import com.app.ecom.dto.UserResponse;
import com.app.ecom.model.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    public List<UserResponse> fetchAllUsers();
    public void addUser(UserRequest userRequest);
    public Optional<UserResponse> fetchUserById(Long id);
    public boolean updateUserById(Long id, UserRequest updatedUserRequest);
}
