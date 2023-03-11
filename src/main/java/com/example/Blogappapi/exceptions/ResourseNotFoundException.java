package com.example.Blogappapi.exceptions;

public class ResourseNotFoundException extends RuntimeException{

    public ResourseNotFoundException(String message) {
        super(message);
    }
}
