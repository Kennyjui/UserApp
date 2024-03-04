package com.example.userapp.exeception.handler;

import com.example.userapp.exeception.response.ExceptionResponse;
import com.example.userapp.exeception.response.UserAlreadyExistException;
import com.example.userapp.exeception.response.UserNotFoundException;
import com.example.userapp.mapper.ExceptionMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RequiredArgsConstructor
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<ExceptionResponse> UserAlreadyExistException(UserAlreadyExistException e, HttpServletRequest request){
        ExceptionResponse exceptionHandler = ExceptionMapper.mapToExceptionResponse(e, request, HttpStatus.CONFLICT);
        return new ResponseEntity<>(exceptionHandler,HttpStatus.CONFLICT);
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionResponse> UserNotFoundException(UserNotFoundException e, HttpServletRequest request){
        ExceptionResponse exceptionHandler = ExceptionMapper.mapToExceptionResponse(e,request,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(exceptionHandler, HttpStatus.NOT_FOUND);
    }

}
