package com.bridglabz.greetingappdevlopment.controller;

import com.bridglabz.greetingappdevlopment.model.GreetingData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/")
    public GreetingData greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new GreetingData(counter.incrementAndGet(),
                String.format(template, name));
    }

}