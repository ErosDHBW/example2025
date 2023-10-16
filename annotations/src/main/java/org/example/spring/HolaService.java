package org.example.spring;

import org.example.spring.Greeter;
import org.springframework.stereotype.Service;

@Service
class HolaService implements Greeter {

    @Override
    public String getGreeting(String name) {
        return "Hola, " + name + "!";
    }
}
