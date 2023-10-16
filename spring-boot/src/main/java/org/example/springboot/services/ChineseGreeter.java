package org.example.springboot.services;

import javax.inject.Named;

@Named
class ChineseGreeter implements Greeter {

    @Override
    public String getGreeting(String name) {
        return "你好, " + name + "!";
    }
    
}
