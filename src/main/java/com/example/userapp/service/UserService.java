package com.example.userapp.service;

import com.example.userapp.dto.UpdateResponse;
import com.example.userapp.dto.UserRequest;
import com.example.userapp.dto.UserResponse;
import com.example.userapp.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<User> createUser(UserRequest request);

    ResponseEntity<UserResponse> getUserById(Long id);

    ResponseEntity<UserResponse> updateUser(Long id, UpdateResponse request);

    ResponseEntity<List<UserResponse>> getAllUsers();

    ResponseEntity<String> deleteUser(Long id);
}
