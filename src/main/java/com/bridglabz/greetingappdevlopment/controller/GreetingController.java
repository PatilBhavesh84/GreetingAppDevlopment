package com.bridglabz.greetingappdevlopment.controller;

import com.bridglabz.greetingappdevlopment.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /*
    UC1-Greeting Controller for Return JSON Messages using
    HTTP methods via @RequestParam and @PathVariable
     */
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
    //locakhost:8080/param/bhavesh
    @GetMapping("/param/{name}")
    public Greeting greeting1(@PathVariable String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    /*
    uc2-Extend GreetingController to use Service Layer to get
    Simple Greeting message "Hello World"
    LOCALHOST:8080/getMap
     */
    @GetMapping("/getMap")
    public String getMessage() {
        return "Hello World";
    }
    //localhost:8080/getPath/bhavesh
    @GetMapping("/getPath/{name}")
    public String getPath(@PathVariable String name) {
        return "Hello " + name;
    }
}