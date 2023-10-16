package org.example.spring;

import org.example.spring.Greeter;

class HolaService implements Greeter {

    @Override
    public String getGreeting(String name) {
        return "Hola, " + name + "!";
    }
}
