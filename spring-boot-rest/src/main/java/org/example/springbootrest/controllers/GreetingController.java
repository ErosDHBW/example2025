package org.example.springbootrest.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/greet")
public class GreetingController {
    Logger log = LoggerFactory.getLogger(GreetingController.class);

    @PostMapping("/{name}")
    public String greet(@PathVariable String name) {
        log.info("Greeting requested for {}", name);
        return "Hello, " + name + "!";
    }
}
