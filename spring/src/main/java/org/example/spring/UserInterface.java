package org.example.spring;

class UserInterface {
    private Greeter greetingService;

    public UserInterface() {}

    public void setGreetingService(Greeter service) {
        this.greetingService = service;
    }

    public void showGreeting() {
        System.out.println(greetingService.getGreeting("user"));
    }
}
