package com.lohika;

import com.lohika.persistent.Greeting;
import com.lohika.persistent.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private GreetingRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        // save a couple of greetings
        repository.save(new Greeting("Namaste!"));
        repository.save(new Greeting("Hi!"));
        repository.save(new Greeting("Bonjour!"));

        // fetch all greetings
        System.out.println("Greetings found with findAll():");
        System.out.println("-------------------------------");

        List<Greeting> greetings = repository.findAll();
        greetings.forEach(greeting -> System.out.println(greeting));

    }
}