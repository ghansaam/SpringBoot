package com.example.crud;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
       return "Hello World ";
   }

    @GetMapping
    public String hello1() {
        return "Hello World 1";
    }
}
