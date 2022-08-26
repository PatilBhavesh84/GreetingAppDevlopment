package com.bridglabz.greetingappdevlopment.model;

import lombok.Data;

@Data
public class GreetingData {
    private long id;
    private String message;

    public GreetingData(long id, String message) {
        this.id = id;
        this.message = message;
    }

}