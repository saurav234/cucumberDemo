package com.cucumber.demo.controllers;


import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping
public class FizzBuzzController {
    public FizzBuzzController() {
    }

    @GetMapping(value={"/fizzBuzzResult/{input}"})
    public String fizzBuzzGamePlay(@PathVariable Long input) {
        if(input != null) {
            if((input % 5 == 0) && !(input % 3 == 0)) {
                return "fizz";
            };
            if((input % 3 == 0) && !(input % 5 == 0)) {
                return "buzz";
            }
            if((input % 3 == 0) && (input % 5 == 0)) {
                return "fizzbuzz";
            }
        }
        return "No Fizz No Buzz";
    }

}
