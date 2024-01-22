package com.karalaitis.planner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, @RequestParam String surname){
        System.out.println("Hello, my name is " + name + " " + surname);
        return "hello";
    }
}
