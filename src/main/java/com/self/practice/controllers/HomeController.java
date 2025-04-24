package com.self.practice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name) {
        System.out.println("----------->"+name);
        return "<h1>Greetings ::</h1><h1 style=\"background-color:Tomato;\"> "+name+"</h1>";
    }


}
