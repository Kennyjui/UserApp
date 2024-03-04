package com.example.userapp.mapper;

import com.example.userapp.dto.UpdateResponse;
import com.example.userapp.dto.UserRequest;
import com.example.userapp.dto.UserResponse;
import com.example.userapp.model.User;

public class UserMapper {
    public static User mapUserRequestToUser(UserRequest request){
        return User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .address(request.getAddress())
                .phoneNumber(request.getPhoneNumber())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }
    public static UserResponse mapUserResponse(User response){
        return UserResponse.builder()
                .id(response.getId())
                .firstName(response.getFirstName())
                .lastName(response.getLastName())
                .email(response.getEmail())
                .phoneNumber(response.getPhoneNumber())
                .password(response.getPassword())
                .address(response.getAddress())
                .build();
    }
    public static User mapUpdateResponseToUser( User user ,UpdateResponse request){
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setAddress(request.getAddress());
        return user;
    }
}
