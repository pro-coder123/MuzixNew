package com.stackroute.exception;

public class TrackNotFoundException extends Exception {
    String message;
    public TrackNotFoundException() {
        this.message = message;
    }

    public TrackNotFoundException(String message) {
        super(message);
        this.message = message;
    }



}
