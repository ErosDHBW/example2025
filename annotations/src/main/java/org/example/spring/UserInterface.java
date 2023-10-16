package org.example.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
class UserInterface {
    @Autowired
    @Qualifier("helloWorldService")
    private Greeter greetingService;

    public UserInterface() {}

    public void setGreetingService(Greeter service) {
        this.greetingService = service;
    }

    public void showGreeting() {
        System.out.println(greetingService.getGreeting("user"));
    }
}
