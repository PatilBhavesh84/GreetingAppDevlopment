package com.bridglabz.greetingappdevlopment.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "greeting")
public class Greeting {
    @Id
    String name;
    long id;
    public Greeting(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Greeting() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}