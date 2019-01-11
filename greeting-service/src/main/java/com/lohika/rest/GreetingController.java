package com.lohika.rest;

import com.lohika.persistent.Greeting;
import com.lohika.persistent.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GreetingController {

    @Autowired
    public GreetingRepository repository;

    @RequestMapping(value = "/greetings", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GreetingDTO> greetings() {
        List<Greeting> greetings = repository.findAll();

        List<GreetingDTO> greetingDTOS = greetings.stream()
                .map(greeting -> new GreetingDTO(greeting.getId(), greeting.getContent()))
                .collect(Collectors.toList());
        return greetingDTOS;
    }

}
