package com.app.ecom.service;

import com.app.ecom.dto.AddressDTO;
import com.app.ecom.dto.UserRequest;
import com.app.ecom.dto.UserResponse;
import com.app.ecom.model.Address;
import com.app.ecom.repository.UserRepository;
import com.app.ecom.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements  UserService{
    private final UserRepository userRepository;

    @Override
    public List<UserResponse> fetchAllUsers() {
        return userRepository.findAll().stream()
                .map(this::mapToUserResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void addUser(UserRequest userRequest) {
        User user = new User();
        updateUserFromRequest(user,userRequest);
        userRepository.save(user);
    }

    @Override
    public Optional<UserResponse> fetchUserById(Long id) {

        return userRepository.findById(id)
                .map(this::mapToUserResponse);
    }

    @Override
    public boolean updateUserById(Long id, UserRequest updatedUserRequest) {
       return userRepository.findById(id)
               .map(existingUser -> {
                   updateUserFromRequest(existingUser,updatedUserRequest);
                   userRepository.save(existingUser);
                   return true;
               }).orElse(false);
    }

    private User updateUserFromRequest(User user, UserRequest userRequest) {
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPhone(userRequest.getPhone());
        if (userRequest.getAddress()!=null) {
            Address address = new Address();
            address.setStreet(userRequest.getAddress().getStreet());
            address.setCity(userRequest.getAddress().getCity());
            address.setState(userRequest.getAddress().getState());
            address.setCountry(userRequest.getAddress().getCountry());
            address.setZipcode(userRequest.getAddress().getZipcode());
            user.setAddress(address);
        }
        return user;
    }

    private UserResponse mapToUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(String.valueOf(user.getId()));
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setEmail(user.getEmail());
        userResponse.setPhone(user.getPhone());
        userResponse.setRole(user.getRole());
        if (user.getAddress() != null) {
            AddressDTO address = new AddressDTO();
            address.setCity(user.getAddress().getCity());
            address.setCountry(user.getAddress().getCountry());
            address.setState(user.getAddress().getState());
            address.setStreet(user.getAddress().getStreet());
            address.setZipcode(user.getAddress().getZipcode());
            userResponse.setAddress(address);
        }
        return userResponse;
    }
}
