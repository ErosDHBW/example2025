package org.example.spring;

import org.example.spring.Greeter;
import javax.inject.Named;

@Named("spanish")
class HolaService implements Greeter {

    @Override
    public String getGreeting(String name) {
        return "Hola, " + name + "!";
    }
}
