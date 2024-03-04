package com.example.userapp.controller;

import com.example.userapp.dto.UpdateResponse;
import com.example.userapp.dto.UserRequest;
import com.example.userapp.dto.UserResponse;
import com.example.userapp.model.User;
import com.example.userapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;
    @PostMapping("create")
    public ResponseEntity<User> createUser(@RequestBody UserRequest request){
        return userService.createUser(request);
    }
    @GetMapping("find-user/{id}")
    public ResponseEntity<UserResponse> findUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PutMapping("update-user/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody UpdateResponse updateResponse){
        return userService.updateUser(id, updateResponse);
    }

    @GetMapping("get-All-Users")
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping("delete-User/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }

}
