package org.example.spring;

import javax.inject.Named;
import javax.inject.Inject;

@Named
class UserInterface {
    @Inject
    @Named("english")
    private Greeter greetingService;

    public UserInterface() {}

    public void setGreetingService(Greeter service) {
        this.greetingService = service;
    }

    public void showGreeting() {
        System.out.println(greetingService.getGreeting("user"));
    }
}
