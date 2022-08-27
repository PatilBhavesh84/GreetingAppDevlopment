package com.bridglabz.greetingappdevlopment.service;

import com.bridglabz.greetingappdevlopment.model.Greeting;
import com.bridglabz.greetingappdevlopment.model.UserData;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService {
    private final AtomicLong counter = new AtomicLong();

    public Greeting getGreeting(UserData userData) {
        long id = counter.incrementAndGet();
        Greeting greeting = new Greeting(id,"Hello "+userData.getFirstName()+" "+userData.getLastName());
        return greeting;
    }
}