package com.example.userapp.exeception.response;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExceptionResponse {
    private int status;
    private String message;
    private String error;
    private String path;
    private LocalDateTime timeStamp;
}
