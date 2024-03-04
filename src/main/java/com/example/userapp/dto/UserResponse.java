package com.example.userapp.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String email;
    private String password;
    private LocalDateTime completed;
}
