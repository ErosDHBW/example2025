package org.example.springboot.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UserInterface {
    Logger log = LoggerFactory.getLogger(UserInterface.class);

    private final Greeter greetingService;

    @Inject    
    public UserInterface(Greeter greetingService) {
        this.greetingService = greetingService;
    }

    public void showGreeting(String name) {
       log.info(this.greetingService.getGreeting(name));
    }

    public String returnGreeting(String name) {
        return this.greetingService.getGreeting(name);
    }
}
