package com.app.ecom.service;

import com.app.ecom.repository.UserRepository;
import com.app.ecom.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements  UserService{
    private final UserRepository userRepository;

    @Override
    public List<User> fetchAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> fetchUserById(Long id) {

        return userRepository.findById(id);
    }

    @Override
    public boolean updateUserById(Long id, User updatedUser) {
       return userRepository.findById(id)
               .map(existingUser -> {
                   existingUser.setFirstName(updatedUser.getFirstName());
                   existingUser.setLastName(updatedUser.getLastName());
                   userRepository.save(existingUser);
                   return true;
               }).orElse(false);
    }
}
