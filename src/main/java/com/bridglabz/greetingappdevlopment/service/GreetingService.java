package com.bridglabz.greetingappdevlopment.service;


import com.bridglabz.greetingappdevlopment.model.Greeting;
import com.bridglabz.greetingappdevlopment.model.UserData;
import com.bridglabz.greetingappdevlopment.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService {
    public static String getMessage() {
        return "Hello World";
    }

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingRepository greetingRepository;

    public Greeting getGreeting(UserData userData) {
        long id = counter.incrementAndGet();
        Greeting greeting = new Greeting(id, userData.getFirstName() + " " + userData.getLastName());
        return greeting;
    }

    public Greeting addGreeting(UserData userData) {
        String message = userData.getFirstName() + " " + userData.getLastName();
        Greeting greeting = new Greeting(counter.incrementAndGet(), message);
        return greetingRepository.save(greeting);
    }

    public Greeting getGreetingById(long id) {
        Greeting greeting = greetingRepository.findById(id).get();
        return greeting;

    }
    public List<Greeting> getAllGreetings() {
        List<Greeting> greetings=greetingRepository.findAll();
        return  greetings;
    }
}