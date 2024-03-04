package com.example.userapp.mapper;

import com.example.userapp.exeception.response.ExceptionResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ExceptionMapper {
    public static ExceptionResponse mapToExceptionResponse(Exception e, HttpServletRequest request, HttpStatus status){
        return ExceptionResponse.builder()
                .message(e.getMessage())
                .error(status.name())
                .path(request.getContextPath())
                .status(status.value())
                .timeStamp(LocalDateTime.now())
                .build();
    }
}
