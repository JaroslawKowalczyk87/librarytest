package com.example.mylibrary;

/**
 * Created by a591566 on 2017-02-17.
 */
public class ApplicationException extends RuntimeException{
    private String message;
    public ApplicationException(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
