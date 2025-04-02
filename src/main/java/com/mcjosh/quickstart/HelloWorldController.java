package com.mcjosh.quickstart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/")
    public String home(){
        return "Welcome!!!";
    }

    @GetMapping(path = "/hello")
    public String helloWorld(){
        return "Hello, Josh!";
    }
}
