package com.example.userapp.dto;

import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateResponse {
    private String firstName;
    private String lastName;
    private String address;
    private Date createdTime;
    private Date updatedTime;
}
