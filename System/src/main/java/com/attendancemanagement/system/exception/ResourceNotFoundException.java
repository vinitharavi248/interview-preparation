package com.attendancemanagement.system.exception;

public class ResourceNotFoundException extends RuntimeException{
//problem caching from the code with helps of string
    public ResourceNotFoundException(String message){
        super(message);
    }
}
