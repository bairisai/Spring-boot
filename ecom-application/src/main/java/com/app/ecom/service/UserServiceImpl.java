package com.app.ecom.service;

import com.app.ecom.User.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}
