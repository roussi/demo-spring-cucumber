package com.example.demospringcucumber.controller;

import com.example.demospringcucumber.response.GreetingResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aroussi
 * @version %I% %G%
 */
@RestController
public class GreetingController {

    @GetMapping("/hello/{name}")
    public GreetingResponse greetMe(@PathVariable String name) {
        return GreetingResponse.builder()
                .message("hello " + name)
                .build();
    }
}

