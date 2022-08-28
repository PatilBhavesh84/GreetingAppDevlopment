package com.bridglabz.greetingappdevlopment.controller;

import com.bridglabz.greetingappdevlopment.model.Greeting;
import com.bridglabz.greetingappdevlopment.model.UserData;
import com.bridglabz.greetingappdevlopment.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    private GreetingService greetingService;

    /*
    UC1 : Using Greeting Controller Return JSON For Different HTTP Methods
    *localhost:8080/greeting
     */
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    //localhost:8080/param/Bhavesh
    @GetMapping("/param/{name}")
    public Greeting greeting1(@PathVariable String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));

    }

     /*
    UC2 : Extend GreetingController To Use Service Layer To Get
    Simple Greeting Message "Hello World"
    *localhost:8080/getMessage
     */

    @GetMapping("/getMessage")
    public String getMessage() {
        return GreetingService.getMessage();
    }


    //localhost:8080/greeting
    @PostMapping("/greeting")
    public Greeting getGreeting(@RequestBody UserData data) {
        Greeting greeting = new Greeting(5, "Hi " + data.getFirstName() + ".This is POST");
        return greeting;
    }

    //localhost:8080/greeting/hello
    @PostMapping("/greeting/hello")
    public Greeting getGreetingHi(@RequestBody UserData data) {
        return new Greeting(counter.incrementAndGet(), String.format(template, data.getLastName()));
    }

    //localhost:8080/greeting/put?name=Bhavesh
    @PutMapping("/greeting/put")
    public Greeting putGreeting(@RequestParam(value = "name") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/greet")
    public Greeting greeting(@RequestParam(value = "FirstName", defaultValue = "") String fname,
                                 @RequestParam(value = "LastName", defaultValue = "") String lname) {

        UserData userData = new UserData();
        userData.setFirstName(fname);
        userData.setLastName(lname);

        GreetingService greetingService = new GreetingService();
        return greetingService.getGreeting(userData);
    }

    /**
     * UC4 : Ability For The Greeting App To Save The Greeting Message
     In The Repository
     * */

    @PostMapping("/greetService")
    public Greeting greeting(@RequestBody UserData userData)
    {
        return  greetingService.addGreeting(userData);
    }

    /**UC5

     */
    @GetMapping("/greetService/{id}")
    public Greeting greeting(@PathVariable long id)
    {
        return  greetingService.getGreetingById(id);
    }
}
