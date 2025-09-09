package com.app.ecom.service;

import com.app.ecom.User.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.stream;

@Service
public class UserServiceImpl implements  UserService{
    List<User> usersList = new ArrayList<User>();

    private Long userId = 1L;
    @Override
    public List<User> fetchAllUsers() {
        return usersList;
    }

    @Override
    public void addUser(User user) {
        user.setId(userId++);
        usersList.add(user);
    }

    @Override
    public Optional<User> fetchUserById(Long id) {

        return usersList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    @Override
    public boolean updateUserById(Long id, User updatedUser) {
        return usersList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .map(existingUser -> {
                       existingUser.setFirstName(updatedUser.getFirstName());
                       existingUser.setLastName(updatedUser.getLastName());
                       return true;
                }).orElse(false);
    }
}
