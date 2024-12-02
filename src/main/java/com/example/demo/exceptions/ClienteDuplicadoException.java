package com.example.demo.exceptions;

public class ClienteDuplicadoException extends RuntimeException {

    public ClienteDuplicadoException(final String message){
        super(message);
    };

}
