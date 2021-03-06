package com.example.demospringcucumber.controller;

import com.example.demospringcucumber.response.GreetingResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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

    @GetMapping("/test")
    public ResponseEntity hello() {
        return ResponseEntity.ok().body(Map.of("status", "up"));
    }
}

