package com.example.userapp.service.userImp;

import com.example.userapp.dto.UpdateResponse;
import com.example.userapp.dto.UserRequest;
import com.example.userapp.dto.UserResponse;
import com.example.userapp.mapper.UserMapper;
import com.example.userapp.model.User;
import com.example.userapp.repository.UserRepository;
import com.example.userapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserImp implements UserService {
    private final UserRepository userRepository;
    @Override
    public ResponseEntity<User> createUser(UserRequest request){
        if(userRepository.existsByEmailOrPhoneNumber(request.getEmail(), request.getPhoneNumber())){
            throw new RuntimeException("User with this details has already been registered");
        }
        User user = userRepository.save(UserMapper.mapUserRequestToUser(request));
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @Override
    public ResponseEntity<UserResponse> getUserById(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));
        return new ResponseEntity<>(UserMapper.mapUserResponse(user), HttpStatus.OK);
    }
    @Override
    public ResponseEntity<UserResponse> updateUser(Long id, UpdateResponse request){
        User user = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User dose not exist"));
        user = userRepository.save(UserMapper.mapUpdateResponseToUser(user, request));
        return new ResponseEntity<>(UserMapper.mapUserResponse(user),HttpStatus.OK);
    }
    @Override
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        List<UserResponse> user = userRepository.findAll().stream().map(UserMapper ::mapUserResponse)
                .collect(Collectors.toList());
        return new ResponseEntity<>((user), HttpStatus.OK);
    }
    @Override
    public ResponseEntity<String> deleteUser(Long id){
        userRepository.deleteById(id);
        return new ResponseEntity<>("user deleted Successfully", HttpStatus.OK);
    }


}
