package com.bridglabz.greetingappdevlopment.repository;
import com.bridglabz.greetingappdevlopment.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<Greeting,Long> {

}